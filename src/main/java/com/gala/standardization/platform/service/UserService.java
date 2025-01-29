package com.gala.standardization.platform.service;


import org.springframework.stereotype.Service;

import com.gala.standardization.platform.authentication.UserAuthenticator;
import com.gala.standardization.platform.entities.City;
import com.gala.standardization.platform.entities.User;
import com.gala.standardization.platform.repository.UserRepository;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserAuthenticator authenticator;

    public UserService(UserRepository userRepository, UserAuthenticator authenticator) {
        this.userRepository = userRepository;
        this.authenticator = authenticator;
    }

    public User registerUser(String username, String password, City city) {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new RuntimeException("Username already exists!");
        }
        User user = new User(username, password,city);
        return userRepository.save(user);
    }

    public boolean authenticateUser(String username, String password) {
        return authenticator.authenticate(username, password);
    }
}
