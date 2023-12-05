package org.soyunmate.mail.sender.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmailDTO{
    private String[] toUser;
    private String subject;
    private String message;
}
