package edu.miu.cs.najeeb.spring.eahomeautomationproject.entity;

import jakarta.persistence.*;

@Entity
public class Trigger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    public Trigger() {
    }

    public Trigger(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Trigger{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
