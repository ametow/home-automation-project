package edu.miu.cs.najeeb.spring.eahomeautomationproject.controller;

import edu.miu.cs.najeeb.spring.eahomeautomationproject.entity.Notification;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.repository.NotificationRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    private final NotificationRepository notificationRepository;

    public NotificationController(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @GetMapping("/user-device")
    public List<Notification> getNotificationsByUserAndDeviceState(
            @RequestParam Long userId,
            @RequestParam String deviceState) {
        return notificationRepository.findNotificationsByUserAndDeviceState(userId, deviceState);}
}
