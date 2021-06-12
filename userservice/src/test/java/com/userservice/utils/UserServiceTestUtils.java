package com.userservice.utils;

import com.userservice.dto.LoginRequest;
import com.userservice.dto.SignupRequest;

public class UserServiceTestUtils {
    static public SignupRequest getValidSignupRequest(){
        SignupRequest request = new SignupRequest();

        request.setEmail("email@hotmail.com");
        request.setPassword("1234");
        request.setEmploymentStatus(PublicEnums.EmploymentStatus.EMPLOYED);
        request.setName("Daniel");
        request.setPhone("123412341");

        return request;
    }

    static public LoginRequest getValidLoginRequest(){
        LoginRequest request = new LoginRequest();

        request.setEmail("email@hotmail.com");
        request.setPassword("1234");

        return request;
    }
}
