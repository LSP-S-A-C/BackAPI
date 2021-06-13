package com.savesgoals.validators;
import com.savesgoals.entity.SavesGoal;
import com.savesgoals.exceptions.ValidateServiceException;
public class SavesGoalsValidator {
    public static void validate(SavesGoal savesGoal) {
        if (savesGoal.getAmountGoal().intValue() < 0) {
            throw new ValidateServiceException("El dinero no puede ser negativo");
        }
        /*
        if (!savesGoal.getAmountGoal().toString().matches("[0-9]+")) {
            throw new ValidateServiceException("El dinero debe ser un numero");
        }*/
    }
}
