package com.financeservice.apiadminfinance.service;
import com.financeservice.apiadminfinance.entity.Category;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;
public interface CategoryService {
    Category create(Category category);
    public Category update(Category category);
    void delete(Long id);
    Optional<Category> listById(Long id);
    List<Category> list(Pageable page);
}