package com.financeservice.apiadminfinance.service;

import com.financeservice.apiadminfinance.converters.SavingSheetsDtoToEntityConverter;
import com.financeservice.apiadminfinance.converters.SavingSheetsEntityToDtoConverter;
import com.financeservice.apiadminfinance.entity.Category;
import com.financeservice.apiadminfinance.repository.CategoryRepository;
import com.financeservice.apiadminfinance.repository.SavingSheetsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

@ExtendWith(SpringExtension.class)
public class SavingSheetsServiceTest {

    @InjectMocks
    private SavingSheetsService savingSheetsService;
    @InjectMocks
    private CategoryService categoryService;
    @InjectMocks
    private SavingSheetsDtoToEntityConverter converter;
    @Mock
    private SavingSheetsRepository savingSheetsRepository;
    @Mock
    private CategoryRepository categoryRepository;
    @Test
    public void DadoDineroActualCuandoEsNegativoEntoncesInvalida(){
        SavingPlan savingPlanDTO = SavingPlanServiceDataTestUtils.getValidCrateSavingPlan();
        BigDecimal cm = new BigDecimal(-200);
        savingPlanDTO.setCurrentMoney(cm);
        ValidateServiceException exception = Assertions.assertThrows(ValidateServiceException.class,
                () -> savingPlanService.create(savingPlanDTO));
        Assertions.assertEquals("El dinero actual no puede ser negativo", exception.getMessage());
    }
    @Test
    public void DadoDineroAhorradoCuandoEsNegativoEntoncesInvalida(){
        SavingPlan savingPlanDTO = SavingPlanServiceDataTestUtils.getValidCrateSavingPlan();
        BigDecimal cs = new BigDecimal(-9000);
        savingPlanDTO.setCurrentSaves(cs);
        ValidateServiceException exception = Assertions.assertThrows(ValidateServiceException.class,
                () -> savingPlanService.create(savingPlanDTO));
        Assertions.assertEquals("Los ahorros no pueden ser numeros negativos", exception.getMessage());
    }
    @Test
    public void DadoPorcentajeAhorroCuandoEsMayorA50EntoncesInvalida(){
        SavingPlan savingPlanDTO = SavingPlanServiceDataTestUtils.getValidCrateSavingPlan();
        savingPlanDTO.setSavesPercent(60);
        ValidateServiceException exception = Assertions.assertThrows(ValidateServiceException.class,
                () -> savingPlanService.create(savingPlanDTO));
        Assertions.assertEquals("Recomendamos que ahorre menos del 50% de sus ingresos", exception.getMessage());
    }
    @Test
    public void DadoPorcentajeAhorroCuandoEsMenorA0EntoncesInvalida(){
        SavingPlan savingPlanDTO = SavingPlanServiceDataTestUtils.getValidCrateSavingPlan();
        savingPlanDTO.setSavesPercent(-90);
        ValidateServiceException exception = Assertions.assertThrows(ValidateServiceException.class,
                () -> savingPlanService.create(savingPlanDTO));
        Assertions.assertEquals("El porcentaje de ahorro no puede ser menor a 0", exception.getMessage());
    }

    @Test
    public void DadoMontoAhorroCuandoEsNegativoEntoncesInvalida(){
        SavesGoal savesGoalDTO = SavingPlanServiceDataTestUtils.getValidCrateSaveGoal();
        BigDecimal AG = new BigDecimal(-90);
        savesGoalDTO.setAmountGoal(AG);
        ValidateServiceException exception = Assertions.assertThrows(ValidateServiceException.class,
                () -> savesGoalService.create(savesGoalDTO));
        Assertions.assertEquals("El dinero no puede ser negativo", exception.getMessage());
    }

}
