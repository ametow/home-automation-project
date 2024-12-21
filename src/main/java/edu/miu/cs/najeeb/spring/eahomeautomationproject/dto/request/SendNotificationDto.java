package edu.miu.cs.najeeb.spring.eahomeautomationproject.dto.request;

import jakarta.validation.constraints.NotNull;

public class SendNotificationDto {
    @NotNull
    private Long userId;
    @NotNull
    private Long deviceId;
    @NotNull
    private String message;

    public SendNotificationDto(Long userId, Long deviceId, String message) {
        this.userId = userId;
        this.deviceId = deviceId;
        this.message = message;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
