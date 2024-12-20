package edu.miu.cs.najeeb.spring.eahomeautomationproject.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@NamedQuery(
        name = "User.findUsersWithActiveDevices",
        query = "SELECT DISTINCT u FROM User u JOIN u.homes h JOIN h.rooms r JOIN r.devices d WHERE d.status = true"
)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;
    private String password;
    private String permission;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<Home> homes;

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Home> getHomes() {
        return homes;
    }

    public void setHomes(List<Home> homes) {
        this.homes = homes;
    }

    public void addHome(Home home) {
        homes.add(home);
        home.setOwner(this);
    }

    public void removeHome(Home home) {
        homes.remove(home);
        home.setOwner(null);
    }

    public void removeAllHomes() {
        for (Home home : homes) {
            home.setOwner(null);
        }
        homes.clear();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", permission='" + permission + '\'' +
                ", homes=" + homes +
                '}';
    }
}
