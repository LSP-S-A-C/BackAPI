package com.financeservice.apiadminfinance.service;
import com.financeservice.apiadminfinance.converters.SavingSheetsDtoToEntityConverter;
import com.financeservice.apiadminfinance.entity.Category;
import com.financeservice.apiadminfinance.exceptions.ValidateServiceException;
import com.financeservice.apiadminfinance.repository.CategoryRepository;
import com.financeservice.apiadminfinance.repository.SavingSheetsRepository;
import com.financeservice.apiadminfinance.service.serviceImpl.CategoryServiceImpl;
import com.financeservice.apiadminfinance.service.serviceImpl.SavingSheetsServiceImpl;
import com.financeservice.apiadminfinance.util.CategoryServiceDataTestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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
    @Test
    public void ExcesiveLengthCategoryName(){
        Category category = CategoryServiceDataTestUtils.getValidCategory();
        category.seCategoryName("Un piano muy bonito, rosado y pequeño");
        ValidateServiceException exception = Assertions.assertThrows(ValidateServiceException.class,
                () -> categoryService.create(category));
        Assertions.assertEquals("El nombre es muy largo (max 30)", exception.getMessage());
    }
    @Test
    public void ShortLengthCategoryName(){
        Category category = CategoryServiceDataTestUtils.getValidCategory();
        category.seCategoryName("Un");
        ValidateServiceException exception = Assertions.assertThrows(ValidateServiceException.class,
                () -> categoryService.create(category));
        Assertions.assertEquals("El nombre es muy corto (min 3)", exception.getMessage());
    }
    @Test
    public void NoLengthCategoryName(){
        Category category = CategoryServiceDataTestUtils.getValidCategory();
        category.seCategoryName("");
        ValidateServiceException exception = Assertions.assertThrows(ValidateServiceException.class,
                () -> categoryService.create(category));
        Assertions.assertEquals("Este dato no puede estar vacío", exception.getMessage());
    }
}
