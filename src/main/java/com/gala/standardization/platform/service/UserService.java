package com.gala.standardization.platform.service;


import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.gala.standardization.platform.Role;
import com.gala.standardization.platform.UserStatus;

import com.gala.standardization.platform.entities.User;
import com.gala.standardization.platform.repository.UserDTO;
import com.gala.standardization.platform.repository.UserRepository;


import org.springframework.security.crypto.password.PasswordEncoder;
 @Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,  PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public boolean authenticateUser(String username, String rawPassword) {
        User user = userRepository.findByUsername(username)
                                  .orElseThrow(() -> new RuntimeException("Authentication fail : User not found"));
        return passwordEncoder.matches(rawPassword, user.getPassword());
    }
    public User findByUsername(String username){
        User user=userRepository.findByUsername(username)
                    .orElseThrow(() -> new RuntimeException("User Search fail : User not found"));
        return user;
    }

    public List<UserDTO> getPendingUsers() {
          return userRepository.findByStatus(UserStatus.PROCESSING)
            .stream()
            .map(user -> new UserDTO(user.getId(), user.getUsername(), user.getCity().getCity_name()))
            .collect(Collectors.toList());
    }

    public void approveUser(UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setStatus(UserStatus.APPROVED);
        userRepository.save(user);
    }

    public void rejectUser(UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setStatus(UserStatus.REJECTED);
        userRepository.save(user);
    }


    // public boolean authenticateUser(String username, String password) {
    //     return authenticator.authenticate(username, password);
    // }
}
