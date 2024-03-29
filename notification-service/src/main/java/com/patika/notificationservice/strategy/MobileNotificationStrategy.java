package com.patika.notificationservice.strategy;

import com.patika.notificationservice.dto.NotificationDTO;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MobileNotificationStrategy implements NotificationStrategy {

    @Value("${twilio.accountSid}")
    private String accountSid;

    @Value("${twilio.authToken}")
    private String authToken;

    @Value("${twilio.fromPhoneNumber}")
    private String fromPhoneNumber;

    @Override
    public void sendNotification(NotificationDTO notificationDTO) {
        log.info("Sending mobile notification: {}", notificationDTO.getMessage());

        Twilio.init(accountSid, authToken);

        String phoneNumber = notificationDTO.getMobileNumber();
        String messageBody = notificationDTO.getMessage();

        Message message = Message.creator(
                        new PhoneNumber(phoneNumber),
                        new PhoneNumber(fromPhoneNumber),
                        messageBody)
                .create();

        if (message.getSid() != null) {
            log.info("Mobile notification sent successfully to {}: {}", phoneNumber, messageBody);
        } else {
            log.error("Failed to send mobile notification to {}: {}", phoneNumber, messageBody);
        }
    }
}

