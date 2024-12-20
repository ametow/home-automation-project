package edu.miu.cs.najeeb.spring.eahomeautomationproject.dto.response;

import edu.miu.cs.najeeb.spring.eahomeautomationproject.entity.Device;

import java.util.List;

public class DeviceResponseDto {
    private Long id;
    private String name;
    private String manufacturer;
    private Boolean status;
    private String type;
    private Integer energyConsumptionPerHour;

    public DeviceResponseDto(Long id, String name, String manufacturer, Boolean status, String type, Integer energyConsumptionPerHour) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.status = status;
        this.type = type;
        this.energyConsumptionPerHour = energyConsumptionPerHour;
    }


    public static DeviceResponseDto fromDevices(Device output) {
        return new DeviceResponseDto(output.getId(), output.getName(), output.getManufacturer(), output.getStatus(), output.getType().toString(), output.getEnergyConsumptionPerHour());
    }

    public static List<DeviceResponseDto> fromDevices(List<Device> output) {
        return output.stream().map(DeviceResponseDto::fromDevices).toList();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public Boolean getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public Integer getEnergyConsumptionPerHour() {
        return energyConsumptionPerHour;
    }

}
