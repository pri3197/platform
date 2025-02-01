package com.gala.standardization.platform.repository;


import com.gala.standardization.platform.Role;
import com.gala.standardization.platform.UserStatus;
import com.gala.standardization.platform.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByUsername(String username);
    List<User> findByRole(Role role);
    List<User> findByStatus(UserStatus status);
}

