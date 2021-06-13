package com.financeservice.apiadminfinance.service.serviceImpl;

import com.financeservice.apiadminfinance.entity.CashFlow;
import com.financeservice.apiadminfinance.entity.Category;
import com.financeservice.apiadminfinance.exceptions.GeneralServiceException;
import com.financeservice.apiadminfinance.exceptions.NoDataFoundException;
import com.financeservice.apiadminfinance.exceptions.ValidateServiceException;
import com.financeservice.apiadminfinance.repository.CategoryRepository;
import com.financeservice.apiadminfinance.service.CategoryService;
import com.financeservice.apiadminfinance.validators.CategoryValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    public Category create(Category category) {
        try {
            CategoryValidator.validate(category);
            return categoryRepository.save(category);
        } catch (ValidateServiceException | NoDataFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new GeneralServiceException(e.getMessage(), e);
        }
    }

    public Category update(Category category) {
        return categoryRepository.save(category);
    }

    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    public Optional<Category> listById(Long id) {
        return categoryRepository.findById(id);
    }

    public List<Category> list(Pageable page) {
        return categoryRepository.findAll(page).toList();
    }

}