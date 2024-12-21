package edu.miu.cs.najeeb.spring.eahomeautomationproject.dto.request;

import jakarta.validation.constraints.NotNull;

public class DeviceEventCreateDto {
    @NotNull
    private Long deviceId;
    @NotNull
    private Long triggerId;
    @NotNull
    private Long actionId;

    public DeviceEventCreateDto() {
    }

    public DeviceEventCreateDto(Long deviceId, Long triggerId, Long actionId) {
        this.deviceId = deviceId;
        this.triggerId = triggerId;
        this.actionId = actionId;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public Long getTriggerId() {
        return triggerId;
    }

    public void setTriggerId(Long triggerId) {
        this.triggerId = triggerId;
    }

    public Long getActionId() {
        return actionId;
    }

    public void setActionId(Long actionId) {
        this.actionId = actionId;
    }
}
