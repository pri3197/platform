package com.gala.standardization.platform.authentication;



import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Optional;
import org.springframework.stereotype.Component;

import com.gala.standardization.platform.entities.User;
import com.gala.standardization.platform.repository.UserRepository;

@Component
public class UserAuthenticator extends Authenticator {

    private final UserRepository userRepository;

    public UserAuthenticator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        String username = getRequestingPrompt();
        PasswordAuthentication passwordAuthentication= getPasswordAuthentication();
        
        if (username == null || passwordAuthentication.getPassword() == null) {
            return null;
        }

        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isPresent() && userOptional.get().getPassword().equals(new String(passwordAuthentication.getPassword()))) {
            
            return new PasswordAuthentication(username, passwordAuthentication.getPassword());
        }

        return null;
    }

    public boolean authenticate(String username, String password) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        return userOptional.isPresent() && userOptional.get().getPassword().equals(password);
    }
}
