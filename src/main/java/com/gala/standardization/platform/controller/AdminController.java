package com.gala.standardization.platform.controller;



import com.gala.standardization.platform.entities.User;
import com.gala.standardization.platform.repository.UserDTO;
import com.gala.standardization.platform.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
//@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/pendingUsers")
    public ResponseEntity<List<UserDTO>> getPendingUsers() {
        System.out.println("Entering /pending-users endpoint"); 
        List<UserDTO> pendingUsers = userService.getPendingUsers();
        System.out.println(pendingUsers.size());
        return ResponseEntity.ok(pendingUsers);
    }

    @PostMapping("/approve/{userId}")
    public ResponseEntity<?> approveUser(@PathVariable UUID userId) {
        userService.approveUser(userId);
        return ResponseEntity.ok().body("User approved successfully");
    }

    @PostMapping("/reject/{userId}")
    public ResponseEntity<?> rejectUser(@PathVariable UUID userId) {
        userService.rejectUser(userId);
        return ResponseEntity.ok().body("User rejected successfully");
    }
}
