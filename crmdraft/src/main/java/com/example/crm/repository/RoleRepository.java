package com.example.crm.repository;

import com.example.crm.entity.ERole;
import com.example.crm.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

//@Repository
//@EnableJpaRepositories
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(ERole name);
}
