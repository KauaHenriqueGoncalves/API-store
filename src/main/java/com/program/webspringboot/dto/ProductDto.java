package com.program.webspringboot.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.program.webspringboot.entities.Category;
import com.program.webspringboot.entities.Order;
import com.program.webspringboot.entities.OrderItem;
import com.program.webspringboot.entities.Product;
import org.springframework.beans.BeanUtils;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ProductDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imgUrl;
    private Set<Category> categories = new HashSet<>();
    private Set<OrderItem> itens = new HashSet<>();

    public ProductDto() {
    }

    public ProductDto(Product product) {
        BeanUtils.copyProperties(product, this);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    @JsonIgnore
    public Set<Order> getOrders() {
        Set<Order> orders = new HashSet<>();

        for (OrderItem orderItem : this.itens) {
            orders.add(orderItem.getOrder());
        }

        return orders;
    }
}
