package com.quick_order.service;

import com.quick_order.dto.AddCategoryRequest;
import com.quick_order.entity.Categories;
import com.quick_order.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;

    public String addCategory(AddCategoryRequest request) {
        Categories savedCategory = repository.save(request.mapToEntity());
        return "Category added with id: " + savedCategory.getId();
    }

    public List<Categories> getAllByMenuId(Integer menuId) {
        return repository.findAllByMenuId(menuId);
    }

    public Categories getById(Integer categoryId) {
        return repository.findById(categoryId).orElse(null);
    }

    public String removeById(Integer itemId) {
        repository.deleteById(itemId);
        return "Category removed with id: " + itemId;
    }

    public String editCategory(AddCategoryRequest request) {
        Categories entity = request.mapToEntity();
        entity.setId(request.getId());
        Categories updatedCategory = repository.save(entity);
        return "Category updated with id: " + updatedCategory.getId();
    }
}
