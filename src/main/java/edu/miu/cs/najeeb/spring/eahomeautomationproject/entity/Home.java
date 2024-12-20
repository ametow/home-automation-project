package edu.miu.cs.najeeb.spring.eahomeautomationproject.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Home {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private User owner;

    @OneToMany(mappedBy = "home", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Room> rooms;

    public Home(String name, Address address, User owner) {
        this.name = name;
        this.address = address;
        this.owner = owner;
    }

    public Home() {
    }

    public void addRoom(Room room) {
        rooms.add(room);
        room.setHome(this);
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

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "Home{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", owner=" + owner +
                ", rooms=" + rooms +
                '}';
    }
}
