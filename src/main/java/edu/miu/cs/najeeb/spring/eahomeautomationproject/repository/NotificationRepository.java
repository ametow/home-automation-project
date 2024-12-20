package edu.miu.cs.najeeb.spring.eahomeautomationproject.repository;

import edu.miu.cs.najeeb.spring.eahomeautomationproject.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    @Query("SELECT n FROM Notification n " +
            "JOIN n.user u JOIN u.homes h JOIN h.rooms r JOIN r.devices d where u.id = :userId AND h.address.state = :deviceState")
    List<Notification> findNotificationsByUserAndDeviceState(Long userId, String deviceState);
}
