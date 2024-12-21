package edu.miu.cs.najeeb.spring.eahomeautomationproject.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.dto.request.SendNotificationDto;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.jms.Producer;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final Producer producer;
    private final UserService userService;
    private final DeviceService deviceService;

    public NotificationService(Producer producer, UserService userService, DeviceService deviceService) {
        this.producer = producer;
        this.userService = userService;
        this.deviceService = deviceService;
    }

    public void sendNotification(String message) {
        producer.sendMessage("notification", message);
    }

    public void sendDeviceInfoToUser(SendNotificationDto dto) throws JsonProcessingException {
        userService.getUserById(dto.getUserId());
        deviceService.getDeviceById(dto.getDeviceId());

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(dto);
        sendNotification(jsonString);
    }
}
