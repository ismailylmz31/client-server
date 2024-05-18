package com.y1forcode.server.controller;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
public class FileUploadController {

    private static final String UPLOAD_DIR = "C:/uploads/";

    @PostMapping("/upload-zip")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File is empty");
        }

        try {
            saveFile(file);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save file");
        }

        return ResponseEntity.ok("File uploaded successfully");
    }

    private void saveFile(MultipartFile file) throws IOException {
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        File uploadedFile = new File(UPLOAD_DIR + file.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(uploadedFile)) {
            fos.write(file.getBytes());
        }
    }
}
