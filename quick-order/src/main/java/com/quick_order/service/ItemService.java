package com.quick_order.service;

import com.quick_order.dto.AddItemRequest;
import com.quick_order.entity.Items;
import com.quick_order.repository.ItemsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemsRepository repository;

    public String addItem(AddItemRequest request) {
        Items savedItem = repository.save(request.mapToEntity());
        return "Item added with id: " + savedItem.getId();
    }
}
