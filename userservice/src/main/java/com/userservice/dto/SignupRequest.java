package com.userservice.dto;
import com.userservice.utils.PublicEnums;
import io.swagger.annotations.ApiModel;
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
@ApiModel(description = "Esta clase representa una solicitud de registro de usuario")
public class SignupRequest {
    private String name;
    private String phone;
    private String email;
    private PublicEnums.EmploymentStatus employmentStatus;
    private String password;
}
