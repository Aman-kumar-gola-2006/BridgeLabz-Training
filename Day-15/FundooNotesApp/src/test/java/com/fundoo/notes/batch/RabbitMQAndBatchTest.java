package com.fundoo.notes.batch;

import com.fundoo.notes.dto.NoteEvent;
import com.fundoo.notes.entity.Note;
import com.fundoo.notes.entity.User;
import com.fundoo.notes.messaging.RabbitMQProducer;
import com.fundoo.notes.repository.NoteRepository;
import com.fundoo.notes.repository.UserRepository;
import com.fundoo.notes.service.ExcelExportService;
import com.fundoo.notes.service.ExcelImportService;
import com.fundoo.notes.service.NoteService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RabbitMQAndBatchTest {

    @Autowired
    private ExcelExportService excelExportService;

    @Autowired
    private ExcelImportService excelImportService;

    @Autowired
    private NoteService noteService;

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job importNotesJob;

    @Autowired(required = false)
    private RabbitMQProducer rabbitMQProducer;

    private User testUser;

    @BeforeEach
    void setUp() {
        testUser = userRepository.findByEmail("day17user@example.com").orElseGet(() -> {
            User user = new User("Day17", "User", "day17user@example.com", "password123");
            return userRepository.save(user);
        });

        noteRepository.deleteAll();
    }

    @Test
    void testExcelExportAndImportWorkflow() throws Exception {
        // 1. Create notes
        Note note1 = new Note("Shopping List", "Buy Milk, Eggs, Bread", testUser);
        Note note2 = new Note("Meeting Notes", "Discuss Q3 Sprint Goals", testUser);
        noteRepository.saveAll(List.of(note1, note2));

        // 2. Export to Excel bytes
        byte[] excelBytes = excelExportService.exportNotesToExcel("day17user@example.com");
        assertNotNull(excelBytes);
        assertTrue(excelBytes.length > 0);

        // Verify Excel structure using Apache POI
        try (InputStream is = new ByteArrayInputStream(excelBytes); Workbook workbook = new XSSFWorkbook(is)) {
            Sheet sheet = workbook.getSheetAt(0);
            assertEquals("Notes", sheet.getSheetName());
            assertEquals("ID", sheet.getRow(0).getCell(0).getStringCellValue());
            // Since notes are ordered by CreatedAt Desc, row 1 contains Meeting Notes
            assertEquals("Meeting Notes", sheet.getRow(1).getCell(1).getStringCellValue());
        }

        // 3. Import from generated Excel
        MockMultipartFile file = new MockMultipartFile(
                "file",
                "test_notes.xlsx",
                "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
                excelBytes
        );

        noteRepository.deleteAll(); // clear DB before import test

        List<Note> imported = excelImportService.importNotesFromExcel(file, "day17user@example.com");
        assertFalse(imported.isEmpty());
        assertEquals(2, imported.size());
    }

    @Test
    void testSpringBatchJobExecution() throws Exception {
        JobParameters params = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())
                .toJobParameters();

        JobExecution execution = jobLauncher.run(importNotesJob, params);
        assertEquals(BatchStatus.COMPLETED, execution.getStatus());
    }

    @Test
    void testFileAttachmentUploadAndDownload() throws Exception {
        Note note = new Note("Attachment Test", "Note with file attachment", testUser);
        Note savedNote = noteRepository.save(note);

        MockMultipartFile file = new MockMultipartFile(
                "file",
                "sample.txt",
                "text/plain",
                "Hello Fundoo Notes Attachment!".getBytes()
        );

        var response = noteService.uploadAttachment(savedNote.getId(), "day17user@example.com", file);
        assertEquals("sample.txt", response.getAttachmentFileName());

        Path downloadedFile = noteService.getAttachmentFile(savedNote.getId(), "day17user@example.com");
        assertTrue(Files.exists(downloadedFile));
        assertEquals("Hello Fundoo Notes Attachment!", Files.readString(downloadedFile));
    }

    @Test
    void testRabbitMQProducerEventFormat() {
        assertDoesNotThrow(() -> {
            if (rabbitMQProducer != null) {
                rabbitMQProducer.sendNoteEvent(101L, "TEST_EVENT", "Title Test", "day17user@example.com");
            }
        });
    }
}
