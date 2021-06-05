package com.userservice.converters;
import com.userservice.dto.SignupRequest;
import com.userservice.entity.User;
import lombok.NoArgsConstructor;
@NoArgsConstructor
public class UserConverter {

    
    public User signup(SignupRequest dto) {
        return User.builder()
                .email(dto.getEmail())
                .name(dto.getName())
                .phone(dto.getPhone())
                .employmentStatus(dto.getEmploymentStatus())
                .password(dto.getPassword())
                .build();
    }
}
