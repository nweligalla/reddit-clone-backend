package com.nweligalla.redditClone.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailNotification {

    private String subject;
    private String recipient;
    private String body;
}
