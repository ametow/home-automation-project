package edu.miu.cs.najeeb.spring.eahomeautomationproject.service;

import edu.miu.cs.najeeb.spring.eahomeautomationproject.entity.Device;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.entity.DeviceEvent;
import edu.miu.cs.najeeb.spring.eahomeautomationproject.repository.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.OptimisticLockException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DeviceService {
    private final DeviceRepositoryCustomImpl deviceRepositoryCustom;
    private final DeviceRepository deviceRepository;
    private final TriggerRepository triggerRepository;
    private final ActionRepository actionRepository;
    private final DeviceEventRepository deviceEventRepository;


    public DeviceService(DeviceRepositoryCustomImpl deviceRepositoryCustom, DeviceRepository deviceRepository, TriggerRepository triggerRepository, ActionRepository actionRepository, DeviceEventRepository deviceEventRepository) {
        this.deviceRepositoryCustom = deviceRepositoryCustom;
        this.deviceRepository = deviceRepository;
        this.triggerRepository = triggerRepository;
        this.actionRepository = actionRepository;
        this.deviceEventRepository = deviceEventRepository;
    }

    public List<Device> findDevicesByState(String state) {
        return deviceRepositoryCustom.findDevicesByState(state);
    }

    public List<Device> findDevicesByManufacturerAndMinEnergy(String manufacturer, Double minEnergy) {
        return deviceRepositoryCustom.findDevicesByManufacturerAndMinEnergy(manufacturer, minEnergy);
    }

    public Device createDevice(Device device) {
        return deviceRepository.save(device);
    }

    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    public Device getDeviceById(Long id) {
        return deviceRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Device not found"));
    }

    public void updateDevice(Device device) {
        deviceRepository.save(device);
    }

    public void deleteDevice(Long id) {
        deviceRepository.deleteById(id);
    }

    public List<Device> findDevicesByRoomId(Long roomId) {
        return deviceRepositoryCustom.findDevicesByRoomId(roomId);
    }


    // optimistic locking example
    @Transactional
    public Device updateDeviceState(Long deviceId, String newState) {
        try {
            Device device = deviceRepository.findById(deviceId)
                    .orElseThrow(() -> new RuntimeException("Device not found"));
            device.setStatus(newState.equals("ON"));
            return deviceRepository.save(device);
        } catch (OptimisticLockException e) {
            throw new RuntimeException("Device state was modified by another transaction. Please try again.", e);
        }
    }


    // pessimistic locking example
    @Transactional
    public Device lockAndModifyDevice(Long deviceId, String newManufacturer) {
        Device device = deviceRepository.findDeviceByIdForUpdate(deviceId)
                .orElseThrow(() -> new RuntimeException("Device not found"));
        device.setManufacturer(newManufacturer);
        return deviceRepository.save(device);
    }

    public DeviceEvent createDeviceEvent(Long deviceId, Long triggerId, Long actionId) {
        DeviceEvent deviceEvent = new DeviceEvent();
        deviceEvent.setDevice(deviceRepository.findById(deviceId).orElseThrow(() -> new EntityNotFoundException("Device not found")));
        deviceEvent.setTrigger(triggerRepository.findById(triggerId).orElseThrow(() -> new EntityNotFoundException("Trigger not found")));
        deviceEvent.setAction(actionRepository.findById(actionId).orElseThrow(() -> new EntityNotFoundException("Action not found")));
        deviceEventRepository.save(deviceEvent);
        return deviceEvent;
    }
}
