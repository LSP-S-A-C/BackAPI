package com.userservice.validators;
import com.userservice.entity.User;
import com.userservice.exceptions.ValidateServiceException;
public class UserValidator {
    public static void validate(User user) {
        if (user.getName() == null || user.getName().trim().isEmpty()) {
            throw new ValidateServiceException("El nombre es requerido");
        }
        if (user.getName().length() > 20) {
            throw new ValidateServiceException("El nombre es muy largo (max 20 caracteres)");
        }
        if (user.getName().length() < 3) {
            throw new ValidateServiceException("El nombre es muy corto (min 3 caracteres)");
        }
        if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
            throw new ValidateServiceException("La contraseña es requerida");
        }
        if (user.getPassword().length() > 20) {
            throw new ValidateServiceException("La contraseña es muy larga (max 20 caracteres)");
        }
        if (user.getPassword().length() < 3) {
            throw new ValidateServiceException("La contraseña es muy corta (min 3 caracteres)");
        }
        if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
            throw new ValidateServiceException("El email es requerido");
        }
        if (user.getPhone() == null || user.getPhone().trim().isEmpty()) {
            throw new ValidateServiceException("El numero de celular es requerido");
        }
    }
    
}
