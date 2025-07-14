package com.program.webspringboot.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.program.webspringboot.entities.Category;
import com.program.webspringboot.entities.Product;
import org.springframework.beans.BeanUtils;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class CategoryDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Set<Product> products = new HashSet<>();

    public CategoryDto() {
    }

    public CategoryDto(Category category) {
        BeanUtils.copyProperties(category, this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public Set<Product> getProducts() {
        return products;
    }
}
