package com.userservice.service;

import com.userservice.converters.UserConverter;
import com.userservice.dto.LoginRequest;
import com.userservice.dto.SignupRequest;
import com.userservice.entity.User;
import com.userservice.exceptions.ValidateServiceException;
import com.userservice.repository.UserRepository;
import com.userservice.utils.PublicEnums;
import com.userservice.utils.UserServiceTestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
public class UserServiceTest {
    @InjectMocks
    private UserService userService;

    @InjectMocks
    private UserConverter userConverter;

    @Mock
    private UserRepository userRepository;

    //Flujo de registro
    @DisplayName("Debería mostrar error en caso de que el email del usuario sea inválido")
    @Test
    public void shouldThrowErrorWhenEmailInvalid(){
        SignupRequest request = UserServiceTestUtils.getValidSignupRequest();

        request.setEmail("email_hotmail.com");

        ValidateServiceException exception = Assertions.assertThrows(ValidateServiceException.class,
                () -> userService.register(userConverter.signup(request)));

        Assertions.assertEquals(PublicEnums.ExceptionMessagesUser.EMAIL_INVALID.getValue(), exception.getMessage());
    }

    //Flujo de login
    @DisplayName("Debería mostrar error en caso de que el usuario no sea encontrado al momento del login")
    @Test
    public void shouldThrowErrorWhenUserNotFound(){
        LoginRequest request = UserServiceTestUtils.getValidLoginRequest();

        request.setEmail("email_hotmail.com");

        Mockito.when(userRepository.findByEmail(Mockito.anyString())).thenThrow(new ValidateServiceException(PublicEnums.ExceptionMessagesUser.EMAIL_OR_PASSWORD_INVALID));

        ValidateServiceException exception = Assertions.assertThrows(ValidateServiceException.class,
                () -> userService.login(request));

        Assertions.assertEquals(PublicEnums.ExceptionMessagesUser.EMAIL_OR_PASSWORD_INVALID.getValue(), exception.getMessage());
    }

    //Encontrar usuario
    @DisplayName("Debería retornar un Optional.empty() en caso de que el ID del usuario no sea encontrado")
    @Test
    public void shouldThrowErrorWhenUserIdNotFound(){
        Long id = 42L;

        Mockito.when(userRepository.findById(Mockito.any(Long.class))).thenReturn(Optional.empty());

        Optional<User> optional = userService.findbyID(id);

        Assertions.assertEquals(Optional.empty(), optional);
    }

    //
    @DisplayName("Debería retornar mostrar error en caso de que el estado laboral no se haya elegido")
    @Test
    public void shouldThrowErrorWhenEmployementStatusIsNull () {
        SignupRequest request = UserServiceTestUtils.getValidSignupRequest();

        request.setEmploymentStatus(null);

        ValidateServiceException exception = Assertions.assertThrows(ValidateServiceException.class,
                () -> userService.register(userConverter.signup(request)));

        Assertions.assertEquals(PublicEnums.ExceptionMessagesUser.EMPLOYEMENTSTATUS_REQUIRED.getValue(),exception.getMessage());
    }
}