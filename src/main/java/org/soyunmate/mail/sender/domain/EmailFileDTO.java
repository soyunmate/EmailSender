package org.soyunmate.mail.sender.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmailFileDTO {
    private String[] toUser;
    private String subject;
    private String message;
    private MultipartFile file;
}
