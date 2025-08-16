package com.quick_order.dto;

import com.quick_order.entity.Items;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddItemRequest {

    private Integer id;
    private Integer categoryId;
    private Integer menuId;
    private String name;
    private String description;
    private Double price;
    private String ingredients;
    private String weight;
    private String image;
    private Boolean isVeg;
    private Boolean isActive;

    public Items mapToEntity() {
        return Items.builder()
                .categoryId(categoryId)
                .menuId(menuId)
                .name(name)
                .description(description)
                .price(price)
                .ingredients(ingredients)
                .weight(weight)
                .image(image)
                .isVeg(isVeg)
                .isActive(isActive)
                .build();
    }

}
