package com.financeservice.apiadminfinance.converters;

import com.financeservice.apiadminfinance.dtos.CategoryDto;
import com.financeservice.apiadminfinance.entity.Category;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryEntityToDtoConverter  {
    @Autowired
    private ModelMapper modelMapper;
    public CategoryDto convertEntityToDto(Category category) {
        return modelMapper.map(category, CategoryDto.class);
    }
    public List<CategoryDto> convertEntityToDto(List<Category> categories) {
        return categories.stream()
                .map(category -> convertEntityToDto(category))
                .collect(Collectors.toList());
    }
}