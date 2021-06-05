package com.userservice.dto;
import com.userservice.utils.PublicEnums;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SignupRequest {
    private String name;
    private String phone;
    private String email;
    private PublicEnums.EmploymentStatus employmentStatus;
    private String password;
}
