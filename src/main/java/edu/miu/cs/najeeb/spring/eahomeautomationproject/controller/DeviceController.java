package edu.miu.cs.najeeb.spring.eahomeautomationproject.controller;

import edu.miu.cs.najeeb.spring.eahomeautomationproject.dto.request.DeviceCreateDto;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.dto.response.DeviceResponseDto;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.entity.Device;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.entity.Room;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.repository.DeviceRepository;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.repository.DeviceRepositoryCustomImpl;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.service.DeviceService;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.service.RoomService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
@Validated
public class DeviceController {
    private final DeviceService deviceService;
    private final RoomService roomService;

    public DeviceController(DeviceService deviceService, RoomService roomService) {
        this.deviceService = deviceService;
        this.roomService = roomService;
    }

    @GetMapping("/room/{roomId}")
    public List<DeviceResponseDto> getDevicesByRoomId(@PathVariable Long roomId) {
        var output = deviceService.findDevicesByRoomId(roomId);
        return DeviceResponseDto.fromDevices(output);
    }

    @GetMapping("/state")
    public List<DeviceResponseDto> getDevicesByState(@RequestParam String state) {
        var output = deviceService.findDevicesByState(state);
        return DeviceResponseDto.fromDevices(output);
    }

    @GetMapping("/manufacturer-energy")
    public List<DeviceResponseDto> getDevicesByManufacturerAndEnergy(
            @RequestParam String manufacturer,
            @RequestParam Double minEnergy) {
        var output = deviceService.findDevicesByManufacturerAndMinEnergy(manufacturer, minEnergy);
        return DeviceResponseDto.fromDevices(output);
    }

    @PostMapping
    public DeviceCreateDto createDevice(@RequestBody @Valid DeviceCreateDto device) {
        Room room = roomService.getById(device.getRoomId());

        Device newDevice = new Device();
        newDevice.setName(device.getName());
        newDevice.setManufacturer(device.getManufacturer());
        newDevice.setStatus(device.getStatus());
        newDevice.setType(device.getType());
        newDevice.setEnergyConsumptionPerHour(device.getEnergyConsumptionPerHour());
        newDevice.setRoom(room);

        deviceService.createDevice(newDevice);
        return device;
    }

    @GetMapping("/{id}")
    public DeviceResponseDto getDevice(@PathVariable Long id) {
        Device output = deviceService.getDeviceById(id);
        return DeviceResponseDto.fromDevices(output);
    }

    @DeleteMapping("/{id}")
    public void deleteDevice(@PathVariable Long id) {
        deviceService.deleteDevice(id);
    }


    @GetMapping("/update-state")
    public Device updateDeviceState(
            @RequestParam Long deviceId,
            @RequestParam String newState) {
        return deviceService.updateDeviceState(deviceId, newState);
    }

    @GetMapping("/lock-modify")
    public Device lockAndModifyDevice(
            @RequestParam Long deviceId,
            @RequestParam String newManufacturer) {
        return deviceService.lockAndModifyDevice(deviceId, newManufacturer);
    }

}
