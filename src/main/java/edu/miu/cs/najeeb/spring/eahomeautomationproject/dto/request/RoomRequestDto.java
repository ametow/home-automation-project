package edu.miu.cs.najeeb.spring.eahomeautomationproject.dto.request;

import jakarta.validation.constraints.NotNull;

public class RoomRequestDto {
    @NotNull
    private String name;
    @NotNull
    private Long homeId;

    public RoomRequestDto() {
    }

    public RoomRequestDto(String name, Long homeId) {
        this.name = name;
        this.homeId = homeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getHomeId() {
        return homeId;
    }

    public void setHomeId(Long homeId) {
        this.homeId = homeId;
    }

    @Override
    public String toString() {
        return "RoomRequestDto{" +
                "name='" + name + '\'' +
                ", homeId=" + homeId +
                '}';
    }
}
