package com.y1forcode.client.controller;




import com.y1forcode.client.service.FileSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
public class FileSenderController {

    @Autowired
    private FileSenderService fileSenderService;

    @GetMapping("/send-zip")
    public String sendZipFile(@RequestParam String filePath, @RequestParam String url) {
        File file = new File(filePath);
        if (file.exists()) {
            fileSenderService.sendZipFile(url, file);
            return "File sent successfully!";
        } else {
            return "File not found!";
        }
    }
}
