package com.userservice.dto;
import com.userservice.entity.User;
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
@ApiModel(description = "Esta clase representa una respuesta de solicitud de login")
public class LoginResponse {
    private User user;
    private String token;
}
