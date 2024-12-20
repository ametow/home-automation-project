package edu.miu.cs.najeeb.spring.eahomeautomationproject.controller;

import edu.miu.cs.najeeb.spring.eahomeautomationproject.dto.request.RegisterRequestDto;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.entity.User;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUser(HttpSession session) {
        System.out.println(session.getId());
        return userService.getAllUsers();
    }

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequestDto user) {
        return userService.saveUser(user.toUser());
    }

    @GetMapping("/active-devices")
    public List<User> getUsersWithActiveDevices() {
        return userService.findUsersWithActiveDevices();
    }

}
