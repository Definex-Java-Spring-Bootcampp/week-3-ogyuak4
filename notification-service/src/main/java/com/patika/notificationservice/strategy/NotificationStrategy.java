package com.patika.notificationservice.strategy;

import com.patika.notificationservice.dto.NotificationDTO;

public interface NotificationStrategy {
    void sendNotification(NotificationDTO notificationDTO);

    default Object getNotificationType(NotificationDTO notificationDTO) {
        return notificationDTO.getNotificationType();
    }
}

