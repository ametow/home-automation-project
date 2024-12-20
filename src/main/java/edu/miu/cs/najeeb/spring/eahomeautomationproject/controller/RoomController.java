package edu.miu.cs.najeeb.spring.eahomeautomationproject.controller;

import edu.miu.cs.najeeb.spring.eahomeautomationproject.dto.request.RoomRequestDto;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.dto.response.RoomResponseDto;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.entity.Home;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.entity.Room;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.service.HomeService;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@Validated
public class RoomController {

    private final RoomService roomService;
    private final HomeService homeService;

    public RoomController(RoomService roomService, HomeService homeService) {
        this.roomService = roomService;
        this.homeService = homeService;
    }

    @GetMapping
    public List<RoomResponseDto> getRooms() {
        var rooms = roomService.getAll();
        return RoomResponseDto.from(rooms);
    }

    @GetMapping("/{id}")
    public RoomResponseDto getRoomById(@PathVariable Long id) {
        var room = roomService.getById(id);
        return RoomResponseDto.from(room);
    }

    @PostMapping
    public RoomResponseDto saveRoom(@RequestBody @Valid RoomRequestDto roomResponseDto) {
        Room room = new Room();
        room.setName(roomResponseDto.getName());
        Home home = homeService.getById(roomResponseDto.getHomeId());
        room.setHome(home);
        roomService.save(room);
        return RoomResponseDto.from(room);
    }

    @PutMapping("/{id}")
    public RoomResponseDto updateRoom(@PathVariable Long id, @RequestBody @Valid RoomRequestDto roomRequestDto) {
        Room room = roomService.getById(id);
        room.setName(roomRequestDto.getName());
        Home home = homeService.getById(roomRequestDto.getHomeId());
        room.setHome(home);
        roomService.save(room);
        return RoomResponseDto.from(room);
    }

    @DeleteMapping("/{id}")
    public void deleteRoom(@PathVariable Long id) {
        roomService.delete(id);
    }
}
