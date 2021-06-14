package com.financeservice.apiadminfinance.service;

import com.financeservice.apiadminfinance.converters.SavingSheetsDtoToEntityConverter;
import com.financeservice.apiadminfinance.entity.Category;
import com.financeservice.apiadminfinance.entity.SavingSheets;
import com.financeservice.apiadminfinance.exceptions.ValidateServiceException;
import com.financeservice.apiadminfinance.repository.CategoryRepository;
import com.financeservice.apiadminfinance.repository.SavingSheetsRepository;
import com.financeservice.apiadminfinance.service.serviceImpl.CategoryServiceImpl;
import com.financeservice.apiadminfinance.service.serviceImpl.SavingSheetsServiceImpl;
import com.financeservice.apiadminfinance.util.CategoryServiceDataTestUtils;
import com.financeservice.apiadminfinance.util.SavingSheetsServiceDataTestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

@ExtendWith(SpringExtension.class)
public class CategoryServiceTest {

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
        Category category = CategoryServiceDataTestUtils.getValidCategory();
        Integer priority = -2;
        category.setPriority(priority);
        ValidateServiceException exception = Assertions.assertThrows(ValidateServiceException.class,
                () -> categoryService.create(category));
        Assertions.assertEquals("No pueden haber prioridades negativas", exception.getMessage());
    }
}
