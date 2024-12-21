package edu.miu.cs.najeeb.spring.eahomeautomationproject.security;

import edu.miu.cs.najeeb.spring.eahomeautomationproject.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class UserPrinciple implements UserDetails {

    private final User user;

    public UserPrinciple(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (user.getPermission() == null) {
            return new ArrayList<>();
        }
        return Arrays.stream(user.getPermission().split(",")).map(s -> new SimpleGrantedAuthority("ROLE_"+s)).toList();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public String toString() {
        return "UserPrinciple{" +
                "user=" + user +
                '}';
    }
}
