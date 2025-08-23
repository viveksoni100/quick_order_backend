package com.quick_order.service;

import com.quick_order.dto.AddTableRequest;
import com.quick_order.entity.TableInfo;
import com.quick_order.repository.TableInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author viveksoni100
 */
@Service
@RequiredArgsConstructor
public class TableService {

    private final TableInfoRepository repository;

    public String addTable(AddTableRequest request) {
        TableInfo savedTableInfo = repository.save(request.mapToEntity());
        return "Table added with id: " + savedTableInfo.getId();
    }

    public List<TableInfo> getAllByOutletId(Integer outletId) {
        return repository.findAllByOutletId(outletId);
    }

    public TableInfo getById(Integer categoryId) {
        return repository.findById(categoryId).orElse(null);
    }

    public String removeById(Integer itemId) {
        repository.deleteById(itemId);
        return "Table removed with id: " + itemId;
    }

    public String editTable(AddTableRequest request) {
        TableInfo entity = request.mapToEntity();
        entity.setId(request.getId());
        TableInfo updatedTableInfo = repository.save(entity);
        return "Table updated with id: " + updatedTableInfo.getId();
    }
}
