package edu.miu.cs.najeeb.spring.eahomeautomationproject.dto.response;

import edu.miu.cs.najeeb.spring.eahomeautomationproject.entity.Device;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.entity.Room;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class RoomResponseDto {
    @NotNull
    private Long id;
    @NotNull
    private String name;
    private List<Device> devices;

    public RoomResponseDto() {
    }

    public RoomResponseDto(Long id, String name, List<Device> devices) {
        this.id = id;
        this.name = name;
        this.devices = devices;
    }

    public static RoomResponseDto from(Room room) {
        return new RoomResponseDto(room.getId(), room.getName(), room.getDevices());
    }

    public static List<RoomResponseDto> from(List<Room> rooms) {
        return rooms.stream().map(RoomResponseDto::from).toList();
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

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    @Override
    public String toString() {
        return "RoomResponseDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", devices=" + devices +
                '}';
    }
}
