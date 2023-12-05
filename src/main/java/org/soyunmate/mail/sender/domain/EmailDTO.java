package org.soyunmate.mail.sender.domain;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmailDTO{
    private String[] toUser;
    private String subject;
    private String message;
}
