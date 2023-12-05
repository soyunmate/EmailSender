package org.soyunmate.mail.sender.controller;

import org.soyunmate.mail.sender.domain.EmailDTO;
import org.soyunmate.mail.sender.domain.EmailFileDTO;
import org.soyunmate.mail.sender.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/mail")
public class MailController {
    @Autowired
    private IEmailService emailService;


    @PostMapping("/send")
    public ResponseEntity<?> receiveRequestEmail(@RequestBody EmailDTO emailDTO) {
        System.out.println("Email Received:\n" + emailDTO);

        emailService.sendEmail(emailDTO.getToUser(),emailDTO.getSubject(), emailDTO.getMessage());

        Map<String, String> response = new HashMap<>();
        response.put("State","ok");
        response.put("Message", "Email Sended");
        response.put("Date", new Date().toString());

        return ResponseEntity.ok(response);
    }
    @PostMapping("/sendWithFile")
    public ResponseEntity<?> receiveRequestEmailWithFile(@ModelAttribute EmailFileDTO emailFileDTO) {

        try {
            String fileName = emailFileDTO.getFile().getOriginalFilename();
            Path path = Paths.get("src/main/resources/files", fileName);
            Files.createDirectories(path.getParent());
            Files.copy(emailFileDTO.getFile().getInputStream(),path, StandardCopyOption.REPLACE_EXISTING);

            File file = path.toFile();
            emailService.sendEmailWithFile(emailFileDTO.getToUser(), emailFileDTO.getSubject(), emailFileDTO.getMessage(), file);

            Map<String, String> response = new HashMap<>();
            response.put("State","ok");
            response.put("Message", "Email with File Sended");
            response.put("Date", new Date().toString());

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            throw new RuntimeException("Email File Error:\n"+e.getMessage());
        }

    }
}
