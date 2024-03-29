package com.patika.notificationservice.strategy;

import com.patika.notificationservice.dto.NotificationDTO;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Component
@Slf4j
public class SmsNotificationStrategy implements NotificationStrategy {

    @Value("${twilio.accountSid}")
    private String accountSid;

    @Value("${twilio.authToken}")
    private String authToken;

    @Value("${twilio.phoneNumber}")
    private String twilioPhoneNumber;

    @Override
    public void sendNotification(NotificationDTO notificationDTO) {
        String phoneNumber = notificationDTO.getPhoneNumber();
        String message = notificationDTO.getMessage();

        // Initialize Twilio client
        Twilio.init(accountSid, authToken);

        try {
            Message.creator(
                    new PhoneNumber(phoneNumber),
                    new PhoneNumber(twilioPhoneNumber),
                    message
            ).create();

            log.info("SMS notification sent to {}: {}", phoneNumber, message);
        } catch (Exception e) {
            log.error("Failed to send SMS notification: {}", e.getMessage());

        }
    }
}

