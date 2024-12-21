package edu.miu.cs.najeeb.spring.eahomeautomationproject.controller;

import edu.miu.cs.najeeb.spring.eahomeautomationproject.dto.request.CreateHomeRequestDto;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.dto.response.HomeResponseDto;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.dto.response.UserResponseDto;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.entity.Address;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.entity.Home;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.entity.User;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.security.UserPrinciple;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.service.HomeService;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.service.UserService;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class HomeController {

    private final HomeService homeService;
    private final UserService userService;

    public HomeController(HomeService homeService, UserService userService) {
        this.homeService = homeService;
        this.userService = userService;
    }

    @GetMapping("/homes")
    @PreAuthorize("hasRole('USER')")
    public List<HomeResponseDto> getHomes() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        System.out.println("authentication: " + authentication.getAuthorities());
        List<Home> homes = homeService.getAll();
        return HomeResponseDto.from(homes);
    }

    @PostMapping("/homes")
    public HomeResponseDto saveHome(@RequestBody @Valid CreateHomeRequestDto dto) {
        Home home = convertToHome(dto);
        homeService.save(home);
        return HomeResponseDto.from(home);
    }

    private Home convertToHome(CreateHomeRequestDto dto) {
        User user = userService.getUserById(dto.getUserId());
        Home home = new Home();
        home.setName(dto.getName());
        Address address = new Address();
        address.setStreet(dto.getStreet());
        address.setCity(dto.getCity());
        address.setState(dto.getState());
        address.setZip(dto.getZipCode());
        home.setAddress(address);
        home.setOwner(user);
        return home;
    }

    @GetMapping("/homes/{id}")
    public HomeResponseDto getHomeById(@PathVariable Long id) {
        Home home = homeService.getById(id);
        return HomeResponseDto.from(home);
    }

    @DeleteMapping("/homes/{id}")
    public void deleteHome(@PathVariable Long id) {
        homeService.deleteById(id);
    }

    @PutMapping("/homes/{id}")
    public HomeResponseDto updateHome(@PathVariable Long id, @RequestBody @Valid CreateHomeRequestDto dto) {
        Home home = convertToHome(dto);
        Home updatedHome = homeService.updateById(id, home);
        return HomeResponseDto.from(updatedHome);
    }
}
