package edu.miu.cs.najeeb.spring.eahomeautomationproject.dto.response;

import edu.miu.cs.najeeb.spring.eahomeautomationproject.entity.Action;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.entity.Device;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.entity.DeviceEvent;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.entity.Trigger;

public class DeviceEventResponseDto {

    private Long id;
    private DeviceResponseDto device;
    private Trigger trigger;
    private Action action;

    public DeviceEventResponseDto() {
    }

    public DeviceEventResponseDto(Long id, Device device, Trigger trigger, Action action) {
        this.id = id;
        this.device = DeviceResponseDto.fromDevice(device);
        this.trigger = trigger;
        this.action = action;
    }

    public static DeviceEventResponseDto fromDeviceEvent(DeviceEvent device) {
        return new DeviceEventResponseDto(device.getId(), device.getDevice(), device.getTrigger(), device.getAction());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DeviceResponseDto getDevice() {
        return device;
    }

    public void setDevice(DeviceResponseDto device) {
        this.device = device;
    }

    public Trigger getTrigger() {
        return trigger;
    }

    public void setTrigger(Trigger trigger) {
        this.trigger = trigger;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
}
