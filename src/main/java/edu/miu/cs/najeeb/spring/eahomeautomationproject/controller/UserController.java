package edu.miu.cs.najeeb.spring.eahomeautomationproject.controller;

import edu.miu.cs.najeeb.spring.eahomeautomationproject.dto.request.RegisterRequestDto;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.dto.response.UserResponseDto;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.entity.User;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserResponseDto> getUser() {
        var user = userService.getAllUsers();
        return UserResponseDto.from(user);
    }

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequestDto user) {
        return userService.saveUser(user.toUser());
    }

    @GetMapping("/active-devices")
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserResponseDto> getUsersWithActiveDevices() {
        return UserResponseDto.from(userService.findUsersWithActiveDevices());
    }

}
