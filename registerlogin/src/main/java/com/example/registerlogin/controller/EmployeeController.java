package com.example.registerlogin.controller;

import com.example.registerlogin.dto.EmployeeDto;
import com.example.registerlogin.dto.LoginDto;
import com.example.registerlogin.entity.EmployeeEntity;
import com.example.registerlogin.payload.response.LoginResponse;
import com.example.registerlogin.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("api/v1/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping(path = "/add")
    public String addEmployee(@RequestBody EmployeeDto employeeDto) {
        String id = employeeService.addEmployee(employeeDto);
        return id;
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginEmployee(@RequestBody LoginDto loginDto) {
        LoginResponse loginResponse = employeeService.loginEmployee(loginDto);
        return ResponseEntity.ok(loginResponse);
    }

}
