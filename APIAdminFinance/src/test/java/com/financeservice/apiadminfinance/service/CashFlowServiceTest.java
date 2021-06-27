package com.financeservice.apiadminfinance.service;

import com.financeservice.apiadminfinance.converters.SavingSheetsDtoToEntityConverter;
import com.financeservice.apiadminfinance.entity.CashFlow;
import com.financeservice.apiadminfinance.exceptions.ValidateServiceException;
import com.financeservice.apiadminfinance.repository.CategoryRepository;
import com.financeservice.apiadminfinance.repository.SavingSheetsRepository;
import com.financeservice.apiadminfinance.service.serviceImpl.CashFlowServiceImpl;
import com.financeservice.apiadminfinance.service.serviceImpl.CategoryServiceImpl;
import com.financeservice.apiadminfinance.service.serviceImpl.SavingSheetsServiceImpl;
import com.financeservice.apiadminfinance.util.CashFlowServiceDataTestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

@ExtendWith(SpringExtension.class)
public class CashFlowServiceTest {

    @InjectMocks
    private SavingSheetsServiceImpl savingSheetsService;
    @InjectMocks
    private CategoryServiceImpl categoryService;
    @InjectMocks
    private CashFlowServiceImpl cashFlowService;
    @InjectMocks
    private SavingSheetsDtoToEntityConverter converter;
    @Mock
    private SavingSheetsRepository savingSheetsRepository;
    @Mock
    private CategoryRepository categoryRepository;
    @Test
    public void CuandoNoHaSeleccionadoColor(){
        CashFlow cashFlow = CashFlowServiceDataTestUtils.getValidCashFlow();
        cashFlow.setColor(null);
        ValidateServiceException exception = Assertions.assertThrows(ValidateServiceException.class,
                () -> cashFlowService.create(cashFlow));
        Assertions.assertEquals("Seleccione un color", exception.getMessage());
    }
    @Test
    public void CuandoElRecurrenteEstaVacio(){
        CashFlow cashFlow = CashFlowServiceDataTestUtils.getValidCashFlow();
        cashFlow.setRecurrent(null);
        ValidateServiceException exception = Assertions.assertThrows(ValidateServiceException.class,
                () -> cashFlowService.create(cashFlow));
        Assertions.assertEquals("Este dato no puede estar vacio", exception.getMessage());
    }
    @Test
    public void CuandoElMontoEsMenorOIgualACero(){
        CashFlow cashFlow = CashFlowServiceDataTestUtils.getValidCashFlow();
        cashFlow.setAmount(BigDecimal.valueOf(-2.65));
        ValidateServiceException exception = Assertions.assertThrows(ValidateServiceException.class,
                () -> cashFlowService.create(cashFlow));
        Assertions.assertEquals("El monto debe ser mayor a 0", exception.getMessage());
    }
    @Test
    public void ExcesiveLengthCashFlowName(){
        CashFlow cashFlow = CashFlowServiceDataTestUtils.getValidCashFlow();
        cashFlow.setCashFlowName("Un piano muy bonito, rosado y pequeño") ;
        ValidateServiceException exception = Assertions.assertThrows(ValidateServiceException.class,
                () -> cashFlowService.create(cashFlow));
        Assertions.assertEquals("El nombre es muy largo (max 30)", exception.getMessage());
    }
    @Test
    public void ShortLengthCashFlowName(){
        CashFlow cashFlow = CashFlowServiceDataTestUtils.getValidCashFlow();
        cashFlow.setCashFlowName("Un") ;
        ValidateServiceException exception = Assertions.assertThrows(ValidateServiceException.class,
                () -> cashFlowService.create(cashFlow));
        Assertions.assertEquals("El nombre es muy corto (min 3)", exception.getMessage());
    }
    @Test
    public void NoLengthCashFlowName(){
        CashFlow cashFlow = CashFlowServiceDataTestUtils.getValidCashFlow();
        cashFlow.setCashFlowName("") ;
        ValidateServiceException exception = Assertions.assertThrows(ValidateServiceException.class,
                () -> cashFlowService.create(cashFlow));
        Assertions.assertEquals("Este dato no puede estar vacío", exception.getMessage());
    }
}
