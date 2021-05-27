package com.nweligalla.redditClone.service;

import com.nweligalla.redditClone.exception.RedditCloneException;
import com.nweligalla.redditClone.model.EmailNotification;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class MailService {

    private final JavaMailSender mailSender;
    private final MailContentBuilder mailContentBuilder;

    @Async
    void sendMail(EmailNotification emailNotification) {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("redditClone@email.com");
            messageHelper.setTo(emailNotification.getRecipient());
            messageHelper.setSubject(emailNotification.getSubject());
            messageHelper.setText(mailContentBuilder.build(emailNotification.getBody()));
        };

        try {
            mailSender.send(messagePreparator);
            log.info("Activation email sent!");
        } catch (MailException e) {
            throw new RedditCloneException("Exception occured when sending a mail to");
        }
    }

}
