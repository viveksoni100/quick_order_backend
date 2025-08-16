package com.quick_order.service;

import com.quick_order.dto.AddCategoryRequest;
import com.quick_order.entity.Categories;
import com.quick_order.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;

    public String addCategory(AddCategoryRequest request) {
        Categories savedCategory = repository.save(request.mapToEntity());
        return "Item added with id: " + savedCategory.getId();
    }
}
