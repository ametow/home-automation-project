package edu.miu.cs.najeeb.spring.eahomeautomationproject.dto.response;

import edu.miu.cs.najeeb.spring.eahomeautomationproject.entity.Address;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.entity.Home;

import java.util.List;

public class HomeResponseDto {
    private Long id;
    private String name;
    private Address address;
    private UserResponseDto owner;

    public HomeResponseDto(Long id, String name, Address address, UserResponseDto owner) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.owner = owner;
    }

    public HomeResponseDto() {
    }

    public static HomeResponseDto from(Home home) {
        UserResponseDto userResponseDto = new UserResponseDto(home.getOwner().getId(), home.getOwner().getUsername(), home.getOwner().getPermission());
        return new HomeResponseDto(home.getId(), home.getName(), home.getAddress(), userResponseDto);
    }

    public static List<HomeResponseDto> from(List<Home> homes) {
        return homes.stream().map(HomeResponseDto::from).toList();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public UserResponseDto getOwner() {
        return owner;
    }
}
