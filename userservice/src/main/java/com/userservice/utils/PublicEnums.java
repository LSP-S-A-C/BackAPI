package com.userservice.utils;

public class PublicEnums {
    public enum EmploymentStatus {
        UNEMPLOYED, EMPLOYED
    }

    public enum Currency {
        PEN, USD, EUR
    }

    public enum ExceptionMessagesUser{
        //Validator
        USER_REQUIRED("El usuario es requerido"),
        NAME_REQUIRED("El nombre es requerido"),
        NAME_TOO_LONG("El nombre es muy largo (max 20 caracteres)"),
        NAME_TOO_SHORT("El nombre es muy corto (min 3 caracteres)"),
        PASSWORD_REQUIRED("La contraseña es requerida"),
        PASSWORD_TOO_LONG("La contraseña es muy larga (max 20 caracteres)"),
        PASSWORD_TOO_SHORT("La contraseña es muy corta (min 3 caracteres)"),
        EMAIL_REQUIRED("El email es requerido"),
        EMAIL_INVALID("El email no es válido"),
        PHONE_REQUIRED("El numero de celular es requerido"),
        PHONE_INVALID("El numero de celular no es válido"),
        EMPLOYEMENTSTATUS_REQUIRED("El estado laboral es requerido"),

        //Service
        EMAIL_ALREADY_EXISTS("El email ya existe"),
        PHONE_ALREADY_EXISTS("El numero celular ya existe"),
        EMAIL_OR_PASSWORD_INVALID("Email o password incorrecto");

        private String value;

        ExceptionMessagesUser(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }
}

