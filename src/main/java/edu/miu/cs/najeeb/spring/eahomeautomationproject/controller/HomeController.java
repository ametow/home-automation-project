package edu.miu.cs.najeeb.spring.eahomeautomationproject.controller;

import edu.miu.cs.najeeb.spring.eahomeautomationproject.dto.request.CreateHomeRequestDto;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.dto.response.HomeResponseDto;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.dto.response.UserResponseDto;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.entity.Address;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.entity.Home;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.entity.User;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.service.HomeService;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.service.UserService;
import jakarta.validation.Valid;
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
    public List<HomeResponseDto> getHomes() {
        List<Home> homes = homeService.getAll();
        return HomeResponseDto.from(homes);
    }

    @PostMapping("/homes")
    public HomeResponseDto saveHome(@RequestBody @Valid CreateHomeRequestDto dto) {
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

        homeService.save(home);
        UserResponseDto userResponseDto = new UserResponseDto(user.getId(), user.getUsername(), user.getPermission());
        return new HomeResponseDto(home.getId(), home.getName(), home.getAddress(), userResponseDto);
    }

    @GetMapping("/homes/{id}")
    public Home getHomeById(@PathVariable Long id) {
        return homeService.getById(id);
    }

    @DeleteMapping("/homes/{id}")
    public void deleteHome(@PathVariable Long id) {
        homeService.deleteById(id);
    }

    @PutMapping("/homes/{id}")
    public Home updateHome(@PathVariable Long id, @RequestBody @Valid Home home) {
        return homeService.updateById(id, home);
    }
}
