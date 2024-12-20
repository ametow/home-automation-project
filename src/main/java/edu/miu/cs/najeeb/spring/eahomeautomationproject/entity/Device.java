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

    @Enumerated(EnumType.STRING)
    private DeviceType type;

    private int energyConsumptionPerHour;

    @ManyToOne(optional = false)
    private Room room;

    @OneToMany(mappedBy = "device", cascade = CascadeType.PERSIST)
    private List<DeviceEvent> deviceEvents;

    public void addDeviceEvent(DeviceEvent deviceEvent) {
        deviceEvents.add(deviceEvent);
        deviceEvent.setDevice(this);
    }

    public Device() {
    }

    public Device(String name, DeviceType type, int energyConsumptionPerHour) {
        this.name = name;
        this.type = type;
        this.energyConsumptionPerHour = energyConsumptionPerHour;
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
