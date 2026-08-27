package com.fundoo.notes.service;

import com.fundoo.notes.entity.Note;
import com.fundoo.notes.entity.Note.NoteState;
import com.fundoo.notes.entity.User;
import com.fundoo.notes.repository.NoteRepository;
import com.fundoo.notes.repository.UserRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ExcelImportService {

    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    public ExcelImportService(NoteRepository noteRepository, UserRepository userRepository) {
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public List<Note> importNotesFromExcel(MultipartFile file, String userEmail) throws Exception {
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + userEmail));

        List<Note> importedNotes = new ArrayList<>();

        try (InputStream inputStream = file.getInputStream(); Workbook workbook = new XSSFWorkbook(inputStream)) {
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // Skip header row
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Cell titleCell = currentRow.getCell(0);
                Cell descCell = currentRow.getCell(1);

                if (titleCell == null && descCell == null) {
                    continue;
                }

                String title = getCellValueAsString(titleCell);
                String description = getCellValueAsString(descCell);

                if (title == null || title.trim().isEmpty()) {
                    continue;
                }

                Note note = new Note();
                note.setTitle(title.trim());
                note.setDescription(description != null ? description.trim() : "");
                note.setState(NoteState.ACTIVE);
                note.setUser(user);

                importedNotes.add(note);
            }
        }

        if (!importedNotes.isEmpty()) {
            return noteRepository.saveAll(importedNotes);
        }

        return importedNotes;
    }

    private String getCellValueAsString(Cell cell) {
        if (cell == null) {
            return "";
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf((long) cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            default:
                return "";
        }
    }
}
