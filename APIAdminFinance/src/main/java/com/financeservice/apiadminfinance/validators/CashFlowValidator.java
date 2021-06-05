package com.financeservice.apiadminfinance.validators;

import com.financeservice.apiadminfinance.entity.CashFlow;
import com.financeservice.apiadminfinance.exceptions.ValidateServiceException;

import java.math.BigDecimal;

public class CashFlowValidator {
    public static void save(CashFlow cashFlow){
        if(cashFlow.getCashFlowName().length() > 30) {
            throw new ValidateServiceException("El nombre es muy largo (max 30)");
        }

        if(cashFlow.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValidateServiceException("El monto debe ser mayor a 0");
        }

        if(cashFlow.getRecurrent() == null) {
            throw new ValidateServiceException("Este dato no puede estar vacio");
        }

        if(cashFlow.getColor() == null) {
            throw new ValidateServiceException("Seleccione un color");
        }
    }
}
