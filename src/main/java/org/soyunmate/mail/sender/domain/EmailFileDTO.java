package org.soyunmate.mail.sender.domain;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmailFileDTO {
    private String[] toUser;
    private String subject;
    private String message;
    private MultipartFile file;
}
