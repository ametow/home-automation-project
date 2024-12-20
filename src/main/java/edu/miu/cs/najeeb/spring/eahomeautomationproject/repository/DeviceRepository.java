package edu.miu.cs.najeeb.spring.eahomeautomationproject.repository;

import edu.miu.cs.najeeb.spring.eahomeautomationproject.entity.Device;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DeviceRepository extends JpaRepository<Device, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT d FROM Device d WHERE d.id = :deviceId")
    Optional<Device> findDeviceByIdForUpdate(Long deviceId);
}
