package com.userservice.controller;

import com.userservice.converters.UserConverter;
import com.userservice.dto.*;
import com.userservice.entity.User;
import com.userservice.service.UserService;
import com.userservice.utils.WrapperResponse;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserConverter userConverter;

    @PostMapping("/signup")
    @ApiOperation("Recibe un request de signup y el usuario creado si la creación del usuario fue realizada con éxito")
    public ResponseEntity<WrapperResponse<User>> signup(@RequestBody SignupRequest request){
        User user = userService.register(userConverter.signup(request));
        return new WrapperResponse<>(true, "success", user).createResponse();
    }

    @PostMapping("/login")
    @ApiOperation("Recibe un request de login y retorna el token de sesión si los datos brindados son correctos, " +
                  "de lo contrario, retorna un error")
    public ResponseEntity<WrapperResponse<LoginResponse>> login(@RequestBody LoginRequest request){
        LoginResponse response = userService.login(request);
        return new WrapperResponse<>(true, "success", response).createResponse();
    }

    @GetMapping("/{id}")
    @ApiOperation("Retorna el usuario con el ID brindado")
    public ResponseEntity<WrapperResponse<UserDTO>> findById(@PathVariable(name="id") Long id){
        User user = userService.findbyID(id).get();

        List<SavingPlanDTO> savingPlans = userService.getSavingsPlanByUserId(id.toString());

        UserDTO userDTO = userConverter.userDTO(user);

        userDTO.setSavingPlans(savingPlans);

        return new WrapperResponse<>(true, "success", userDTO).createResponse();
    }
}
