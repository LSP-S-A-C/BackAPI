package com.financeservice.apiadminfinance.validators;

import com.financeservice.apiadminfinance.entity.Category;
import com.financeservice.apiadminfinance.exceptions.ValidateServiceException;

public class CategoryValidator {
    public static void save(Category category){
        if(category.getCashFlows() == null || category.getCashFlows().isEmpty()) {
            throw new ValidateServiceException("Los flujos de efectivo son requeridas");
        }

        if(category.getCategoryName().length() > 30) {
            throw new ValidateServiceException("El nombre es muy largo (max 30)");
        }

        if(category.getPriority() < 0){
            throw new ValidateServiceException("No pueden haber prioridades negativas");
        }
    }
}
