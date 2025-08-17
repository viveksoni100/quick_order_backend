package com.quick_order.dto;

import com.quick_order.entity.Categories;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author viveksoni100
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddCategoryRequest {

    private Integer id;
    private Integer menuId;
    private String name;

    public Categories mapToEntity() {
        return Categories.builder()
                .menuId(menuId)
                .name(name)
                .build();
    }
}
