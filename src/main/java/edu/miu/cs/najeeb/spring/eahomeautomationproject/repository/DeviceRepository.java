package edu.miu.cs.najeeb.spring.eahomeautomationproject.repository;

import edu.miu.cs.najeeb.spring.eahomeautomationproject.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {
}
