package com.quick_order.service;

import com.quick_order.dto.AddItemRequest;
import com.quick_order.entity.Items;
import com.quick_order.repository.ItemsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemsRepository repository;

    public String addItem(AddItemRequest request) {
        Items savedItem = repository.save(request.mapToEntity());
        return "Item added with id: " + savedItem.getId();
    }

    public List<Items> getAllByMenuId(Integer menuId) {
        return repository.findAllByMenuIdAndIsActiveTrue(menuId);
    }

    public Items getById(Integer itemId) {
        return repository.findById(itemId).orElse(null);
    }

    public String removeById(Integer itemId) {
        repository.deleteById(itemId);
        return "Item removed with id: " + itemId;
    }

    public String editItem(AddItemRequest request) {
        Items entity = request.mapToEntity();
        entity.setId(request.getId());
        Items updatedItem = repository.save(entity);
        return "Item updated with id: " + updatedItem.getId();
    }
}
