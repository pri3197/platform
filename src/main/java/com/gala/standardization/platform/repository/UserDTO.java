package com.gala.standardization.platform.repository;

import java.util.UUID;

import com.gala.standardization.platform.Role;
import com.gala.standardization.platform.UserStatus;
import com.gala.standardization.platform.entities.City;

import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("unused")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private UUID userId;
    private String username;
    private String cityName;
    
}
