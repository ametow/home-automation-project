package edu.miu.cs.najeeb.spring.eahomeautomationproject.entity;

import edu.miu.cs.najeeb.spring.eahomeautomationproject.enums.DeviceType;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;
    private String manufacturer;
    private Boolean status;

    @Enumerated(EnumType.STRING)
    private DeviceType type;
    private int energyConsumptionPerHour;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Room room;

    @OneToMany(mappedBy = "device", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<DeviceEvent> deviceEvents;

    @Version
    private int version; // Version field for optimistic locking


    public void addDeviceEvent(DeviceEvent deviceEvent) {
        deviceEvents.add(deviceEvent);
        deviceEvent.setDevice(this);
    }

    public Device() {
    }

    public Device(String name, String manufacturer, Boolean status, DeviceType type, int energyConsumptionPerHour) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.status = status;
        this.type = type;
        this.energyConsumptionPerHour = energyConsumptionPerHour;
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
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Enum<DeviceType> getType() {
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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public List<DeviceEvent> getDeviceEvents() {
        return deviceEvents;
    }

    public void setDeviceEvents(List<DeviceEvent> deviceEvents) {
        this.deviceEvents = deviceEvents;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", energyConsumptionPerHour=" + energyConsumptionPerHour +
                ", room=" + room +
                ", deviceEvents=" + deviceEvents +
                '}';
    }
}
