package com.financeservice.apiadminfinance.controllers;

import com.financeservice.apiadminfinance.converters.CategoryDtoToEntityConverter;
import com.financeservice.apiadminfinance.converters.CategoryEntityToDtoConverter;
import com.financeservice.apiadminfinance.dtos.CategoryDto;
import com.financeservice.apiadminfinance.entity.Category;
import com.financeservice.apiadminfinance.service.CategoryService;
import com.financeservice.apiadminfinance.utils.WrapperResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryEntityToDtoConverter converter1;

    @Autowired
    private CategoryDtoToEntityConverter converter2;

    @ApiOperation(value = " ")
    @GetMapping
    public ResponseEntity<WrapperResponse<List<CategoryDto>>> findAll(
            @RequestParam(name = "pageNumber", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(name = "pageSize", required = false, defaultValue = "5") int pageSize) {
        Pageable page = PageRequest.of(pageNumber, pageSize);
        List<Category> category = categoryService.list(page);
        return new WrapperResponse<>(true, "success", converter1.convertEntityToDto(category)).createResponse();
    }

    @ApiOperation(value = " ")
    @GetMapping("/{id}")
    public ResponseEntity<WrapperResponse<CategoryDto>> findById(@PathVariable(name="id") Long id){
        Category category = categoryService.listById(id).get();
        return new WrapperResponse<>(true, "success", converter1.convertEntityToDto(category)).createResponse();
    }

    @ApiOperation(value = " ")
    @PostMapping
    public ResponseEntity<WrapperResponse<CategoryDto>> create(@RequestBody CategoryDto category){
        Category newCategory = categoryService.create(converter2.convertDtoToEntity(category));
        return new WrapperResponse<>(true, "success", converter1.convertEntityToDto(newCategory)).createResponse();
    }

    @ApiOperation(value = " ")
    @PutMapping
    public ResponseEntity<WrapperResponse<CategoryDto>> update(@RequestBody CategoryDto category){
        Category newCategory = categoryService.update(converter2.convertDtoToEntity(category));
        return new WrapperResponse<>(true, "success", converter1.convertEntityToDto(newCategory)).createResponse();
    }

    @ApiOperation(value = " ")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name="id") Long id){
        categoryService.delete(id);
        return new WrapperResponse<>(true, "success", null).createResponse();
    }

}
