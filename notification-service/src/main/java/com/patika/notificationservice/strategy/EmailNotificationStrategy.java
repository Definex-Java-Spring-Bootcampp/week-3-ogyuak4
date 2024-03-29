package com.patika.notificationservice.strategy;

import com.patika.notificationservice.dto.NotificationDTO;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

@Component
@Slf4j
public class EmailNotificationStrategy implements NotificationStrategy {

    @Value("${email.username}")
    private String emailUsername;

    @Value("${email.password}")
    private String emailPassword;

    @Value("${email.host}")
    private String emailHost;

    @Value("${email.port}")
    private String emailPort;

    @Override
    public void sendNotification(NotificationDTO notificationDTO) {
        log.info("Sending email notification to: {}", notificationDTO.getEmail());
        log.info("Message: {}", notificationDTO.getMessage());

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", emailHost);
        props.put("mail.smtp.port", emailPort);

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(emailUsername, emailPassword);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailUsername));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(notificationDTO.getEmail()));
            message.setSubject("Notification");
            message.setText(notificationDTO.getMessage());

            Transport.send(message);

            log.info("Email sent successfully!");
        } catch (MessagingException e) {
            log.error("Error sending email: {}", e.getMessage());
        }
    }
}

