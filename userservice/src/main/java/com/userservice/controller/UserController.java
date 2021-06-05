package com.userservice.controller;

import com.userservice.converters.UserConverter;
import com.userservice.dto.LoginRequest;
import com.userservice.dto.LoginResponse;
import com.userservice.dto.SignupRequest;
import com.userservice.entity.User;
import com.userservice.service.UserService;
import com.userservice.utils.WrapperResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserConverter userConverter;

    @GetMapping("/lmao")
    public String lmao() {
        return "lol";
    }
    @PostMapping("/signup")
    public ResponseEntity<WrapperResponse<User>> signup(@RequestBody SignupRequest request){
        User user = userService.register(userConverter.signup(request));
        return new WrapperResponse<>(true, "success", user).createResponse();
    }
    @PostMapping("/login")
    public ResponseEntity<WrapperResponse<LoginResponse>> login(@RequestBody LoginRequest request){
        LoginResponse response = userService.login(request);
        return new WrapperResponse<>(true, "success", response).createResponse();
    }
    @GetMapping("/{id}")
    public ResponseEntity<WrapperResponse<User>> findById(@PathVariable(name="id") Long id){
        User user = userService.findbyID(id).get();
        return new WrapperResponse<>(true, "success", user).createResponse();
    }
}
