package com.patika.notificationservice.listener;

import com.patika.notificationservice.dto.NotificationDTO;
import com.patika.notificationservice.dto.enums.NotificationType;
import com.patika.notificationservice.strategy.NotificationStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@Slf4j
public class NotificationListener {

    private final Map<NotificationType, NotificationStrategy> strategyMap;

    public NotificationListener(List<NotificationStrategy> strategies) {
        this.strategyMap = strategies.stream()
                .collect(Collectors.toMap(NotificationStrategy::getNotificationType, Function.identity()));
    }

    @RabbitListener(queues = "${rabbitmq.queue}")
    public void sendNotification(NotificationDTO notificationDTO) {
        NotificationStrategy strategy = strategyMap.get(notificationDTO.getNotificationType());
        if (strategy != null) {
            strategy.sendNotification(notificationDTO);
        } else {
            log.error("No strategy found for notification type: {}", notificationDTO.getNotificationType());
        }
    }
}
