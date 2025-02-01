package com.gala.standardization.platform.entities;


import jakarta.persistence.*;
import java.util.UUID;

import com.gala.standardization.platform.Role;
import com.gala.standardization.platform.UserStatus;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID user_id;

    @Column(name="user_name",unique = true, nullable = false)
    private String username;

    @Column(name="pass_word",nullable = false)
    private String password;

@OneToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @Enumerated(EnumType.STRING)
    @Column(name="role",nullable = false)
    private Role role; 

    @Enumerated(EnumType.STRING)
    @Column(name="user_status",nullable = false)
    private UserStatus status;

    public User() {
        this.status = UserStatus.PROCESSING;
    }

    public User(String username, String password, Role role, City city) {
        this.username = username;
        this.password = password;
        this.city=city;
        this.role=role;
        this.status = UserStatus.PROCESSING;
    }

    // Getters and Setters
    public UUID getId() {
        return user_id;
    }

    public void setId(UUID user_id) {
        this.user_id = user_id;
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
    
    public String getCityId() {
        return city != null ? city.getCityId() : null;
    }

    
    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

  
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    
}
