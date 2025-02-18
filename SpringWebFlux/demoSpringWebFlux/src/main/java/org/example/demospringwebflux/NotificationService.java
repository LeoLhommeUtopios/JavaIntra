package org.example.demospringwebflux;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.UUID;

@Service
public class NotificationService {

    public Flux<Notification> getNotification(){
        return Flux.interval(Duration.ofSeconds(2))
                .map(i -> new Notification(
                        UUID.randomUUID().toString(),
                        "Message :"+i,
                        i%2 == 0
                )).log();
    }

    public Flux<Notification> getFilteredNotification (){
        return getNotification()
                .filter(Notification::isUrgent)
                .map(notification -> {
                    notification.setMessage(notification.getMessage()+ " Urgent!!");
                    return notification;
                });
    }
}
