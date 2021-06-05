package com.financeservice.apiadminfinance.repository;

import com.financeservice.apiadminfinance.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
