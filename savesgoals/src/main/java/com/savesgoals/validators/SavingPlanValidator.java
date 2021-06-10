package com.savesgoals.validators;
import com.savesgoals.entity.SavingPlan;
import com.savesgoals.exceptions.ValidateServiceException;
public class SavingPlanValidator {
    public static void validate(SavingPlan savingPlan) {
        if (savingPlan.getCurrentMoney().intValue() < 0) {
            throw new ValidateServiceException("El dinero actual no puede ser negativo");
        }
        if (savingPlan.getCurrentSaves().intValue() < 0) {
            throw new ValidateServiceException("Los ahorros no pueden ser numeros negativos");
        }
        if (savingPlan.getSavesPercent() < 0) {
            throw new ValidateServiceException("El porcentaje de ahorro no puede ser menor a 0");
        }
        if (savingPlan.getSavesPercent() > 50) {
            throw new ValidateServiceException("Recomendamos que ahorre menos del 50% de sus ingresos");
        }
    }
}
