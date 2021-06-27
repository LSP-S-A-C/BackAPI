package com.financeservice.apiadminfinance.service;

import com.financeservice.apiadminfinance.converters.SavingSheetsDtoToEntityConverter;
import com.financeservice.apiadminfinance.entity.SavingSheets;
import com.financeservice.apiadminfinance.exceptions.ValidateServiceException;
import com.financeservice.apiadminfinance.repository.CategoryRepository;
import com.financeservice.apiadminfinance.repository.SavingSheetsRepository;
import com.financeservice.apiadminfinance.service.serviceImpl.CategoryServiceImpl;
import com.financeservice.apiadminfinance.service.serviceImpl.SavingSheetsServiceImpl;
import com.financeservice.apiadminfinance.util.SavingSheetsServiceDataTestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.time.LocalDateTime;

@ExtendWith(SpringExtension.class)
public class SavingSheetsServiceTest {

    @InjectMocks
    private SavingSheetsServiceImpl savingSheetsService;
    @InjectMocks
    private CategoryServiceImpl categoryService;
    @InjectMocks
    private SavingSheetsDtoToEntityConverter converter;
    @Mock
    private SavingSheetsRepository savingSheetsRepository;
    @Mock
    private CategoryRepository categoryRepository;
    @Test
    public void CuandoLaFechaDeInicioEsMayorALaFinal(){
        SavingSheets savingSheets = SavingSheetsServiceDataTestUtils.getValidSavingSheets();
        LocalDateTime endDate = LocalDateTime.of(2020, 2, 12, 19, 2, 16);
        savingSheets.setEndDate(endDate);
        ValidateServiceException exception = Assertions.assertThrows(ValidateServiceException.class,
                () -> savingSheetsService.create(savingSheets));
        Assertions.assertEquals("La fecha de inicio no puede ser mayor que la final", exception.getMessage());
    }
    @Test
    public void CuandoElPeriodoEsNegativo(){
        SavingSheets savingSheets = SavingSheetsServiceDataTestUtils.getValidSavingSheets();
        Integer period = -5;
        savingSheets.setPeriod(period);
        ValidateServiceException exception = Assertions.assertThrows(ValidateServiceException.class,
                () -> savingSheetsService.create(savingSheets));
        Assertions.assertEquals("El periodo no puede ser negativo", exception.getMessage());
    }
    @Test
    public void CuandoElActiveEsNull(){
        SavingSheets savingSheets = SavingSheetsServiceDataTestUtils.getValidSavingSheets();
        Boolean active = null;
        savingSheets.setActive(active);
        ValidateServiceException exception = Assertions.assertThrows(ValidateServiceException.class,
                () -> savingSheetsService.create(savingSheets));
        Assertions.assertEquals("Especificar estado (activo o inactivo)", exception.getMessage());
    }
    @Test
    public void ExcesiveLengthSavingSheetsName(){
        SavingSheets savingSheets = SavingSheetsServiceDataTestUtils.getValidSavingSheets();
        savingSheets.setSavingSheetsName("Un piano muy bonito, rosado y pequeño");
        ValidateServiceException exception = Assertions.assertThrows(ValidateServiceException.class,
                () -> savingSheetsService.create(savingSheets));
        Assertions.assertEquals("El nombre es muy largo (max 30)", exception.getMessage());
    }
    @Test
    public void ShortLengthSavingSheetsName(){
        SavingSheets savingSheets = SavingSheetsServiceDataTestUtils.getValidSavingSheets();
        savingSheets.setSavingSheetsName("Un");
        ValidateServiceException exception = Assertions.assertThrows(ValidateServiceException.class,
                () -> savingSheetsService.create(savingSheets));
        Assertions.assertEquals("El nombre es muy corto (min 3)", exception.getMessage());
    }
    @Test
    public void NoLengthSavingSheetsName(){
        SavingSheets savingSheets = SavingSheetsServiceDataTestUtils.getValidSavingSheets();
        savingSheets.setSavingSheetsName("");
        ValidateServiceException exception = Assertions.assertThrows(ValidateServiceException.class,
                () -> savingSheetsService.create(savingSheets));
        Assertions.assertEquals("Este dato no puede estar vacío", exception.getMessage());
    }

}
