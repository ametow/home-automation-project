package edu.miu.cs.najeeb.spring.eahomeautomationproject.service;

import edu.miu.cs.najeeb.spring.eahomeautomationproject.entity.User;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    public User saveUser(User user) {
        userRepository.findByUsername(user.getUsername()).ifPresent(u -> {
            throw new IllegalArgumentException("User already exists");
        });
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (user.getPermission() == null)
            user.setPermission("USER");
        return userRepository.save(user);
    }

    public List<User> findUsersWithActiveDevices() {
        return userRepository.findUsersWithActiveDevices();
    }
}
