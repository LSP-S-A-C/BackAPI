package com.financeservice.apiadminfinance.converters;

import com.financeservice.apiadminfinance.dtos.CategoryDto;
import com.financeservice.apiadminfinance.entity.Category;

public class CategoryConverter extends AbstractConverter<Category, CategoryDto>{

    @Override
    public CategoryDto fromEntity(Category entity) {
        if (entity == null) return null;
        return CategoryDto.builder()
                .id(entity.getId())
                .categoryName(entity.getCategoryName())
                .priority(entity.getPriority())
                .savingSheets(entity.getSavingSheets())
                .cashFlows(entity.getCashFlows())

                .build();
    }


    @Override
    public Category fromDTO(CategoryDto dto) {
        if (dto == null) return null;
        return Category.builder()
                .id(dto.getId())
                .categoryName(dto.getCategoryName())
                .priority(dto.getPriority())
                .savingSheets(dto.getSavingSheets())
                .cashFlows(dto.getCashFlows())
                .build();
    }
}
