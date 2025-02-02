package com.gala.standardization.platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.gala.standardization.platform.Role;
import com.gala.standardization.platform.entities.City;
import com.gala.standardization.platform.entities.User;
import com.gala.standardization.platform.security.JWTUtil;
import com.gala.standardization.platform.service.CityService;
import com.gala.standardization.platform.service.UserService;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;




@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final CityService cityService;
    @Autowired private JWTUtil jwtUtil;
  

    public AuthController(UserService userService, CityService cityService) {
        this.userService = userService;
        this.cityService = cityService;
    }
    PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");
        String cityId=request.get("city");


    if (cityId == null || cityId.isEmpty()) {
        return ResponseEntity.badRequest().body(Map.of("error", "City ID is required"));
    }


        // Validate city 
        City city = cityService.getCityById(cityId);
        if (city == null) {
            System.err.println("City object is NULL!  cityId: " + cityId); 
                // Handle the null city . Throwing an exception.
            throw new RuntimeException("City cannot be null during user registration."); 
            }
        System.out.println("City object: " + city.toString()); 
        // Register user
        User user = new User(username, password, Role.ROLE_USER,city);
        System.out.println(username+password+cityId);
        userService.registerUser(user);
        String token = jwtUtil.generateToken(user.getUsername(),user.getRole());
    return ResponseEntity.ok(Map.of("message", "User registered successfully and awaiting admin approval.", "jwt-token", token));
    }



    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Map<String, String> request) {
        try{
        String username = request.get("username");
        String password = request.get("password");
             
              
        boolean authenticated = userService.authenticateUser(username, password);

        User user = userService.findByUsername(username);
        String sessionToken = jwtUtil.generateToken(username, user.getRole());
        if (!authenticated) {
            return ResponseEntity.status(401).body(Map.of("error", "Invalid credentials"));
        }     
        else if(user.getStatus().name()=="PROCESSING") {
            return ResponseEntity.status(401).body(Map.of("error", "Waiting for approval"));
        }
        else if(user.getStatus().name()=="REJECTED") {
            return ResponseEntity.status(401).body(Map.of("error", "Request Rejected"));
        }
    
        return ResponseEntity.ok(Map.of("message", "Login successful","username",user.getUsername(),"userRole",((User) user).getRole(),"jwt-token",sessionToken)); // No need to return a token, Spring Session handles it
        }
        catch (AuthenticationException authExc){
            throw new RuntimeException("Invalid Login Credentials");
        }
    }
}
