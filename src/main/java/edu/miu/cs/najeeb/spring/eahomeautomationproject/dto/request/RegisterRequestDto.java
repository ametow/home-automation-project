package edu.miu.cs.najeeb.spring.eahomeautomationproject.dto.request;

import edu.miu.cs.najeeb.spring.eahomeautomationproject.entity.User;

public record RegisterRequestDto(String username, String password) {

    public RegisterRequestDto {
        if (username == null || username.isBlank() || password == null || password.isBlank()) {
            throw new IllegalArgumentException("Username and password must not be null or empty");
        }
    }

    public User toUser() {
        return new User(username, password);
    }
}
