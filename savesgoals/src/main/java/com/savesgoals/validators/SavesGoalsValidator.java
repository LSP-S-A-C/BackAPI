package com.savesgoals.validators;
import com.savesgoals.entity.SavesGoal;
import com.savesgoals.exceptions.ValidateServiceException;
public class SavesGoalsValidator {
    public static void validate(SavesGoal savesGoal) {
        if (savesGoal.getAmountGoal().intValue() < 0) {
            throw new ValidateServiceException("El dinero no puede ser negativo");
        }
        if(savesGoal.getDescription().lenght()<512){
            throw new ValidateServiceException("Se necesita mínimo 512 caracteres.");
        }
        if (savesGoal.getAmountGoal().intValue() > 10000) {
            throw new ValidateServiceException("El dinero no puede exceder de 10 000.");
        }
        if(savesGoal.getDescription().lenght()<1){
            throw new ValidateServiceException("Este dato no puede estar vacio");
        }
        if(savesGoal.getPathImage().lenght()<1){
            throw new ValidateServiceException("Por favor, suba un archivo de imagen.");
        }
        /*
        if (!savesGoal.getAmountGoal().toString().matches("[0-9]+")) {
            throw new ValidateServiceException("El dinero debe ser un numero");
        }*/
    }
}
