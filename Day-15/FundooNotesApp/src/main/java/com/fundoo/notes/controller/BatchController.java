package com.fundoo.notes.controller;

import com.fundoo.notes.entity.Note;
import com.fundoo.notes.service.ExcelExportService;
import com.fundoo.notes.service.ExcelImportService;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/batch")
public class BatchController {

    private final ExcelExportService excelExportService;
    private final ExcelImportService excelImportService;
    private final JobLauncher jobLauncher;
    private final Job importNotesJob;

    public BatchController(ExcelExportService excelExportService,
                           ExcelImportService excelImportService,
                           JobLauncher jobLauncher,
                           Job importNotesJob) {
        this.excelExportService = excelExportService;
        this.excelImportService = excelImportService;
        this.jobLauncher = jobLauncher;
        this.importNotesJob = importNotesJob;
    }

    @GetMapping("/export/excel")
    public ResponseEntity<byte[]> exportNotesToExcel(Authentication authentication) {
        try {
            String userEmail = authentication.getName();
            byte[] excelContent = excelExportService.exportNotesToExcel(userEmail);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", "fundoo_notes.xlsx");

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(excelContent);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping(value = "/import/excel", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> importNotesFromExcel(@RequestParam("file") MultipartFile file, Authentication authentication) {
        try {
            String userEmail = authentication.getName();
            List<Note> importedNotes = excelImportService.importNotesFromExcel(file, userEmail);

            Map<String, Object> response = new HashMap<>();
            response.put("message", "Notes imported successfully");
            response.put("count", importedNotes.size());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to import Excel file: " + e.getMessage());
        }
    }

    @PostMapping("/run-job")
    public ResponseEntity<?> runBatchJob() {
        try {
            JobParameters params = new JobParametersBuilder()
                    .addLong("time", System.currentTimeMillis())
                    .toJobParameters();

            jobLauncher.run(importNotesJob, params);

            Map<String, String> response = new HashMap<>();
            response.put("message", "Spring Batch Job 'importNotesJob' triggered successfully!");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error running batch job: " + e.getMessage());
        }
    }
}
