package com.financeservice.apiadminfinance.controllers;

import com.financeservice.apiadminfinance.converters.CategoryConverter;
import com.financeservice.apiadminfinance.dtos.CategoryDto;
import com.financeservice.apiadminfinance.entity.Category;
import com.financeservice.apiadminfinance.service.CategoryService;
import com.financeservice.apiadminfinance.utils.WrapperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryConverter categoryConverter;

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> findById(@PathVariable("categoryId") Long categoryId) {
        Category category = categoryService.findById(categoryId);
        CategoryDto categoryDto = categoryConverter.fromEntity(category);
        return new WrapperResponse(true, "success", categoryDto).createResponse(HttpStatus.OK);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<?> delete(@PathVariable("categoryId") Long categoryId) {
        categoryService.delete(categoryId);
        return new WrapperResponse(true, "success", null)
                .createResponse(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> findAll(){
        List<Category> category = categoryService.findAll();
        List<CategoryDto> dtoCaregory = categoryConverter.fromEntity(category);

        return new WrapperResponse(true, "success", dtoCaregory)
                .createResponse(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategoryDto> create(@RequestBody CategoryDto category) {
        Category newCategory = categoryService.save(categoryConverter.fromDTO(category));
        CategoryDto categoryDto = categoryConverter.fromEntity(newCategory);

        return new WrapperResponse(true, "success", categoryDto)
                .createResponse(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CategoryDto> update(@RequestBody CategoryDto category) {
        Category updateCategory = categoryService.save(categoryConverter.fromDTO(category));
        CategoryDto categoryDto = categoryConverter.fromEntity(updateCategory);

        return new WrapperResponse(true, "success", categoryDto)
                .createResponse(HttpStatus.OK);
    }
}
