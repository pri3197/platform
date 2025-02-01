package com.gala.standardization.platform.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.gala.standardization.platform.Role;
import com.gala.standardization.platform.entities.City;
import com.gala.standardization.platform.entities.User;
import com.gala.standardization.platform.service.CityService;
import com.gala.standardization.platform.service.UserService;
import com.gala.standardization.platform.sessionMgmt.SessionStore;
import javax.servlet.http.HttpSession; 
import java.util.Map;
import java.util.UUID;



@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final CityService cityService;
  

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
        User user = new User(username, password, Role.ROLE_ADMIN,city);
        System.out.println(username+password+cityId);
        userService.registerUser(user);
    return ResponseEntity.ok("User registered successfully and awaiting admin approval.");
    }



    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");
       String sessionToken = UUID.randomUUID().toString();
      SessionStore.storeSession(sessionToken, username);
      boolean authenticated = userService.authenticateUser(username, password);
      //HttpSession session=request.  session.setAttribute("username", username); // Store username in the session
       // session.setAttribute("role", user.getRole()); // Store the user's role
        User user = userService.findByUsername(username);
        if (!authenticated) {
            return ResponseEntity.status(401).body(Map.of("error", "Invalid credentials"));
        }       

        return ResponseEntity.ok(Map.of("message", "Login successful","username",user.getUsername(),"userRole",user.getRole(),"token",sessionToken)); // No need to return a token, Spring Session handles it
    
        // if (authenticated) {
        //     return ResponseEntity.ok(Map.of("message", "Login successful","token", sessionToken));
        // } else {
        //     return ResponseEntity.status(401).body(Map.of("error", "Invalid credentials"));
        // }
    }
}
