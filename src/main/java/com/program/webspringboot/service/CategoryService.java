package com.program.webspringboot.service;

import com.program.webspringboot.dto.CategoryDto;
import com.program.webspringboot.entities.Category;
import com.program.webspringboot.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryDto> findAll() {
        List<Category> categoryList = categoryRepository.findAll();
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        categoryList.forEach(category -> categoryDtoList.add(new CategoryDto(category)));
        return categoryDtoList;
    }

    public CategoryDto findById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) return new CategoryDto(category.get());
        return null;
    }

    public CategoryDto insert(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        category = categoryRepository.save(category);
        return new CategoryDto(category);
    }

    public CategoryDto update(Long id, CategoryDto categoryDto) {
        Category category = categoryRepository.getReferenceById(id);
        category.setName(categoryDto.getName());
        category = categoryRepository.save(category);
        return new CategoryDto(category);
    }

    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

}
