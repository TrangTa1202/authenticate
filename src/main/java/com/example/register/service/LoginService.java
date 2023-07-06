package com.example.register.service;

import com.example.register.common.APIResponse;
import com.example.register.dto.SignUpRequestDTO;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    public APIResponse signUp(SignUpRequestDTO signUpRequestDTO) {
        APIResponse apiResponse = new APIResponse();
        apiResponse.setData("its working");
        return apiResponse;
    }
}
