package com.example.registerlogin.service.impl;

import com.example.registerlogin.dto.EmployeeDto;
import com.example.registerlogin.dto.LoginDto;
import com.example.registerlogin.entity.EmployeeEntity;
import com.example.registerlogin.payload.response.LoginResponse;
import com.example.registerlogin.repository.EmployeeRepository;
import com.example.registerlogin.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addEmployee(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = new EmployeeEntity(
                employeeDto.getEmail(),
                employeeDto.getName(),
                this.passwordEncoder.encode(employeeDto.getPassword()));

        employeeEntity = employeeRepository.save(employeeEntity);
        return employeeEntity.getName();
    }


    @Override
    public LoginResponse loginEmployee(LoginDto loginDto) {
        EmployeeEntity employeeEntity1 = employeeRepository.findByEmail(loginDto.getEmail());
        if (employeeEntity1 != null) {
            String password = loginDto.getPassword();
            String encodedPassword = employeeEntity1.getPassword();
            Boolean isPasswordRight = passwordEncoder.matches(password, encodedPassword);

            if (isPasswordRight) {
                Optional<EmployeeEntity> employeeEntity = employeeRepository.findOneByEmailAndPassword(loginDto.getEmail(), encodedPassword);
                if (employeeEntity.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else return new LoginResponse("Login Failed", false);
            } else return new LoginResponse("Password not match", false);
        } else return new LoginResponse("Email not exist", false);


    }
}










