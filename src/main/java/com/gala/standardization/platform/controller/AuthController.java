package com.gala.standardization.platform.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gala.standardization.platform.entities.City;
import com.gala.standardization.platform.entities.User;
import com.gala.standardization.platform.service.CityService;
import com.gala.standardization.platform.service.UserService;

import java.util.Map;

import javax.crypto.EncryptedPrivateKeyInfo;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final CityService cityService;

    public AuthController(UserService userService, CityService cityService) {
        this.userService = userService;
        this.cityService = cityService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");
        String cityId=request.get("city");


    if (cityId == null || cityId.isEmpty()) {
        return ResponseEntity.badRequest().body(Map.of("error", "City ID is required"));
    }


        // Validate city existence
        City city = cityService.getCityById(cityId);
        if (city == null) {
            return ResponseEntity.badRequest().body(Map.of("error", "Invalid city ID"));
        }

        // Register user
        User user = userService.registerUser(username, password, city);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");
        boolean authenticated = userService.authenticateUser(username, password);
        
        if (authenticated) {
            return ResponseEntity.ok(Map.of("message", "Login successful"));
        } else {
            return ResponseEntity.status(401).body(Map.of("error", "Invalid credentials"));
        }
    }
}
