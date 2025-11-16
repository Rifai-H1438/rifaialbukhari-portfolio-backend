package com.rifai_portfolio.controllers;

import com.rifai_portfolio.models.CV;
import com.rifai_portfolio.service.CVService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/cv")
@CrossOrigin(origins = "*")
public class CVController {

    private final CVService cvService;

    public CVController(CVService cvService) {
        this.cvService = cvService;
    }

    // Upload CV
    @PostMapping("/upload")
    public ResponseEntity<String> uploadCV(@RequestParam("file") MultipartFile file) {
        try {
            CV savedCV = cvService.uploadCV(file);
            return ResponseEntity.ok("CV uploaded successfully with ID: " + savedCV.getId());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error uploading CV: " + e.getMessage());
        }
    }

    // Download CV
    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadCV(@PathVariable Long id) {
        CV cv = cvService.getCV(id).orElseThrow(() -> new RuntimeException("CV not found"));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + cv.getFileName() + "\"")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(cv.getData());
    }
}
