package org.example.demospringwebflux;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.awt.*;

@RestController
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping(value = "/notification",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Notification> getNotification(){
        return notificationService.getNotification();
    }

    @GetMapping("/urgence")
    public Flux<Notification> getUrgence (){
        return notificationService.getFilteredNotification();
    }


}

