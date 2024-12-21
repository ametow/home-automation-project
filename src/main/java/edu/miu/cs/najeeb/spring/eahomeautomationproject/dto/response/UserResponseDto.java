package edu.miu.cs.najeeb.spring.eahomeautomationproject.dto.response;

import edu.miu.cs.najeeb.spring.eahomeautomationproject.entity.User;

import java.util.List;

public class UserResponseDto {
    private Long id;
    private String username;
    private String permission;

    public UserResponseDto(Long id, String username, String permission) {
        this.id = id;
        this.username = username;
        this.permission = permission;
    }

    public UserResponseDto() {
    }

    public static List<UserResponseDto> from(List<User> user) {
        return user.stream().map(u -> {
            UserResponseDto dto = new UserResponseDto();
            dto.id = u.getId();
            dto.username = u.getUsername();
            dto.permission = u.getPermission();
            return dto;
        }).toList();
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPermission() {
        return permission;
    }

    @Override
    public String toString() {
        return "UserResponseDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", permission='" + permission + '\'' +
                '}';
    }
}
