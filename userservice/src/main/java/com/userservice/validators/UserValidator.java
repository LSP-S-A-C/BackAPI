package com.userservice.validators;
import com.userservice.entity.User;
import com.userservice.exceptions.ValidateServiceException;
import com.userservice.utils.PublicEnums;

public class UserValidator {
    public static void validate(User user) {
        if (user == null) {
            throw new ValidateServiceException(PublicEnums.ExceptionMessagesUser.USER_REQUIRED);
        }
        if (user.getName() == null || user.getName().trim().isEmpty()) {
            throw new ValidateServiceException(PublicEnums.ExceptionMessagesUser.NAME_REQUIRED);
        }
        if (user.getName().length() > 20) {
            throw new ValidateServiceException(PublicEnums.ExceptionMessagesUser.NAME_TOO_LONG);
        }
        if (user.getName().length() < 3) {
            throw new ValidateServiceException(PublicEnums.ExceptionMessagesUser.NAME_TOO_SHORT);
        }
        if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
            throw new ValidateServiceException(PublicEnums.ExceptionMessagesUser.PASSWORD_REQUIRED);
        }
        if (user.getPassword().length() > 20) {
            throw new ValidateServiceException(PublicEnums.ExceptionMessagesUser.PASSWORD_TOO_LONG);
        }
        if (user.getPassword().length() < 3) {
            throw new ValidateServiceException(PublicEnums.ExceptionMessagesUser.PASSWORD_TOO_SHORT);
        }
        if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
            throw new ValidateServiceException(PublicEnums.ExceptionMessagesUser.EMAIL_REQUIRED);
        }
        if (!user.getEmail().matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")) {
            throw new ValidateServiceException(PublicEnums.ExceptionMessagesUser.EMAIL_INVALID);
        }
        if (user.getPhone() == null || user.getPhone().trim().isEmpty()) {
            throw new ValidateServiceException(PublicEnums.ExceptionMessagesUser.PHONE_REQUIRED);
        }
        if (user.getPhone().length() != 9 || !user.getPhone().matches("-?\\d+(\\.\\d+)?")){
            throw new ValidateServiceException(PublicEnums.ExceptionMessagesUser.PHONE_INVALID);
        }
    }
    
}
