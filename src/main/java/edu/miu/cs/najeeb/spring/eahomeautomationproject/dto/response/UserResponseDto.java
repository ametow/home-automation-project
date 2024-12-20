package edu.miu.cs.najeeb.spring.eahomeautomationproject.dto.response;

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
