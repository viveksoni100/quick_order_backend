package com.quick_order.dto;

import com.quick_order.entity.Categories;
import com.quick_order.entity.TableInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author viveksoni100
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddTableRequest {

    private Integer id;
    private String tableNo;
    private Integer outletId;
    private Integer sittingCapacity;

    public TableInfo mapToEntity() {
        return TableInfo.builder()
                .tableNo(tableNo)
                .outletId(outletId)
                .sittingCapacity(sittingCapacity)
                .build();
    }

}
