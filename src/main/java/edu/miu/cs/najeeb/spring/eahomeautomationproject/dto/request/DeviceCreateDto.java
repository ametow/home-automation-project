package edu.miu.cs.najeeb.spring.eahomeautomationproject.dto.request;

import edu.miu.cs.najeeb.spring.eahomeautomationproject.enums.DeviceType;
import jakarta.validation.constraints.NotNull;

public class DeviceCreateDto {
    @NotNull
    private String name;
    @NotNull
    private String manufacturer;
    @NotNull
    private Boolean status;
    @NotNull
    private DeviceType type;
    @NotNull
    private Integer energyConsumptionPerHour;
    @NotNull
    private Long roomId;

    public DeviceCreateDto(String name, String manufacturer, Boolean status, DeviceType type, int energyConsumptionPerHour, Long roomId) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.status = status;
        this.type = type;
        this.energyConsumptionPerHour = energyConsumptionPerHour;
        this.roomId = roomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public DeviceType getType() {
        return type;
    }

    public void setType(DeviceType type) {
        this.type = type;
    }

    public int getEnergyConsumptionPerHour() {
        return energyConsumptionPerHour;
    }

    public void setEnergyConsumptionPerHour(int energyConsumptionPerHour) {
        this.energyConsumptionPerHour = energyConsumptionPerHour;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
}
