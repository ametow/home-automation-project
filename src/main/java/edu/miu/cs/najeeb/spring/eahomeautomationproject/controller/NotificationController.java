package edu.miu.cs.najeeb.spring.eahomeautomationproject.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.dto.request.SendNotificationDto;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.entity.Notification;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.service.DeviceService;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.service.NotificationService;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.service.UserService;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@Validated
public class NotificationController {
    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService, UserService userService, DeviceService deviceService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/user-device")
    public String getNotificationsByUserAndDeviceState(@RequestBody @Valid SendNotificationDto sendNotificationDto) throws JsonProcessingException {
        notificationService.sendDeviceInfoToUser(sendNotificationDto);
        return "Sent";
    }
}
