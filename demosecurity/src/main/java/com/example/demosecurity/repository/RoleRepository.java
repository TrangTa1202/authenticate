package com.example.demosecurity.repository;

import com.example.demosecurity.model.ERole;
import com.example.demosecurity.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}