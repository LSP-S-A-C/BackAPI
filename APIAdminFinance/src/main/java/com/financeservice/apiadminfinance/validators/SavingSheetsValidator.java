package com.financeservice.apiadminfinance.validators;

import com.financeservice.apiadminfinance.entity.Category;
import com.financeservice.apiadminfinance.entity.SavingSheets;
import com.financeservice.apiadminfinance.exceptions.ValidateServiceException;

public class SavingSheetsValidator {
    public static void validate(SavingSheets savingSheets){

        if(savingSheets.getSavingSheetsName().length() > 30) {
            throw new ValidateServiceException("El nombre es muy largo (max 30)");
        }

        if(savingSheets.getActive() == null) {
            throw new ValidateServiceException("Especificar estado (activo o inactivo)");
        }

        if(savingSheets.getPeriod() < 0) {
            throw new ValidateServiceException("El periodo no puede ser negativo");
        }

        if(savingSheets.getStartDate().compareTo(savingSheets.getEndDate()) >= 0 ) {
            throw new ValidateServiceException("La fecha de inicio no puede ser mayor que la final");
        }
    }
}
