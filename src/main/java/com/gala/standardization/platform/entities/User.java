package com.gala.standardization.platform.entities;


import jakarta.persistence.*;
import java.util.UUID;

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

    public User() {
    }

    public User(String username, String password, City city) {
        this.username = username;
        this.password = password;
        this.city=city;
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
}
