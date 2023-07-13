package com.example.registerlogin.repository;

import com.example.registerlogin.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, String> {
    Optional<EmployeeEntity> findOneByEmailAndPassword(String email, String password);
    EmployeeEntity findByEmail(String email);
}
