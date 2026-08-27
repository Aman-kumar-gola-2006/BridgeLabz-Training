package com.fundoo.notes.service;

import com.fundoo.notes.entity.Note;
import com.fundoo.notes.entity.User;
import com.fundoo.notes.repository.NoteRepository;
import com.fundoo.notes.repository.UserRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ExcelExportService {

    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    public ExcelExportService(NoteRepository noteRepository, UserRepository userRepository) {
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public byte[] exportNotesToExcel(String userEmail) throws IOException {
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found: " + userEmail));

        List<Note> notes = noteRepository.findByUserOrderByCreatedAtDesc(user);

        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Notes");

            // Header Row Style
            CellStyle headerStyle = workbook.createCellStyle();
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setColor(IndexedColors.WHITE.getIndex());
            headerStyle.setFont(headerFont);
            headerStyle.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            // Create Header Row
            Row headerRow = sheet.createRow(0);
            String[] columns = {"ID", "Title", "Description", "State", "Pinned", "Reminder At", "Created At"};
            for (int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
                cell.setCellStyle(headerStyle);
            }

            // Fill Data Rows
            int rowIdx = 1;
            for (Note note : notes) {
                Row row = sheet.createRow(rowIdx++);

                row.createCell(0).setCellValue(note.getId() != null ? note.getId() : 0);
                row.createCell(1).setCellValue(note.getTitle() != null ? note.getTitle() : "");
                row.createCell(2).setCellValue(note.getDescription() != null ? note.getDescription() : "");
                row.createCell(3).setCellValue(note.getState() != null ? note.getState().name() : "ACTIVE");
                row.createCell(4).setCellValue(note.isPinned() ? "Yes" : "No");
                row.createCell(5).setCellValue(note.getReminderAt() != null ? note.getReminderAt().toString() : "");
                row.createCell(6).setCellValue(note.getCreatedAt() != null ? note.getCreatedAt().toString() : "");
            }

            // Auto-size columns
            for (int i = 0; i < columns.length; i++) {
                sheet.autoSizeColumn(i);
            }

            workbook.write(out);
            return out.toByteArray();
        }
    }
}
