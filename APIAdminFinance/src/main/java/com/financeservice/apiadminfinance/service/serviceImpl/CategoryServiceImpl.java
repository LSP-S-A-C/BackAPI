package com.financeservice.apiadminfinance.service.serviceImpl;

import com.financeservice.apiadminfinance.entity.Category;
import com.financeservice.apiadminfinance.exceptions.GeneralServiceException;
import com.financeservice.apiadminfinance.exceptions.NoDataFoundException;
import com.financeservice.apiadminfinance.exceptions.ValidateServiceException;
import com.financeservice.apiadminfinance.repository.CategoryRepository;
import com.financeservice.apiadminfinance.service.CategoryService;
import com.financeservice.apiadminfinance.validators.CategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category findById(Long categoryId){
        try {
            log.debug("findById => " + categoryId);
            Category category = categoryRepository.findById(categoryId)
                    .orElseThrow(() -> new NoDataFoundException("No existe la categoria"));
            return category;
        } catch(ValidateServiceException | NoDataFoundException e) {
            log.info(e.getMessage(), e);
            throw e;
        }catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }

    @Transactional
    public void delete(Long categoryId) {
        try {
            Category category = categoryRepository.findById(categoryId)
                    .orElseThrow(() -> new NoDataFoundException("No existe la categoria"));
            categoryRepository.delete(category);
        } catch (ValidateServiceException | NoDataFoundException e) {
            log.info(e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }

    public List<Category> findAll(){
        try {
            List<Category> category = categoryRepository.findAll();
            return category;
        } catch (ValidateServiceException | NoDataFoundException e) {
            log.info(e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }

    @Transactional
    public Category save(Category category) {
        try {
            CategoryValidator.save(category);

            if(category.getId() == null) {
                Category newCategory = categoryRepository.save(category);
                return newCategory;
            }

            Category exitCategory = categoryRepository.findById(category.getId())
                    .orElseThrow(() -> new NoDataFoundException("No existe el producto"));

            exitCategory.setCategoryName(category.getCategoryName());
            exitCategory.setPriority(category.getPriority());
            exitCategory.setSavingSheets(category.getSavingSheets());
            exitCategory.setCashFlows(category.getCashFlows());
            exitCategory.setSavingSheets(category.getSavingSheets());


            categoryRepository.save(exitCategory);

            return exitCategory;
        } catch (ValidateServiceException | NoDataFoundException e) {
            log.info(e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new GeneralServiceException(e.getMessage(), e);
        }

    }

}
