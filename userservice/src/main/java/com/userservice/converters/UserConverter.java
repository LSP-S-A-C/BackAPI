package com.userservice.converters;
import com.userservice.dto.SignupRequest;
import com.userservice.dto.UserDTO;
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

    public UserDTO userDTO(User entity) {
        return UserDTO.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .name(entity.getName())
                .phone(entity.getPhone())
                .employmentStatus(entity.getEmploymentStatus())
                .build();
    }
}
