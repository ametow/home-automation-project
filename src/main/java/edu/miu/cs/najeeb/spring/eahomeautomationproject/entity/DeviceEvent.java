package edu.miu.cs.najeeb.spring.eahomeautomationproject.entity;

import jakarta.persistence.*;

@Entity
public class DeviceEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST, optional = false)
    private Device device;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, optional = false)
    private Trigger trigger;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, optional = false)
    private Action action;

    public DeviceEvent() {
    }

    public DeviceEvent(Trigger trigger, Action action) {
        this.trigger = trigger;
        this.action = action;
    }

    public DeviceEvent(Device device, Trigger trigger, Action action) {
        this.device = device;
        this.trigger = trigger;
        this.action = action;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
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

    @Override
    public String toString() {
        return "DeviceEvent{" +
                "id=" + id +
                ", device=" + device +
                ", trigger=" + trigger +
                ", action=" + action +
                '}';
    }
}
