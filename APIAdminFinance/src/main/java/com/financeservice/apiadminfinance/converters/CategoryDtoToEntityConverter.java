package com.financeservice.apiadminfinance.converters;

import com.financeservice.apiadminfinance.dtos.CategoryDto;
import com.financeservice.apiadminfinance.entity.Category;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class CategoryDtoToEntityConverter {
    @Autowired
    private ModelMapper modelMapper;
    public Category convertDtoToEntity(CategoryDto categoryDto) {
        return modelMapper.map(categoryDto, Category.class);
    }
    public List<Category> convertDtoToEntity(List<CategoryDto> categoryDTOs) {
        return categoryDTOs.stream()
                .map(categoryDto -> convertDtoToEntity(categoryDto))
                .collect(Collectors.toList());
    }
}