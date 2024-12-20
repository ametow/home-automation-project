package edu.miu.cs.najeeb.spring.eahomeautomationproject.entity;

import jakarta.persistence.*;

@Entity
public class Notification {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;
}
