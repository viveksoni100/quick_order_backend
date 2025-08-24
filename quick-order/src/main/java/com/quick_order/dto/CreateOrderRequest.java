package com.quick_order.dto;

import com.quick_order.entity.OrderInfo;
import com.quick_order.entity.OrderItems;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author viveksoni100
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRequest {

    private String customerName;
    private String customerPhone;
    private String customerEmail;
    private Double billAmount;
    private Double netPayableAmount;
    private Double tax;
    private Double discountPerc;
    private Double discountAmount;
    private Double platformChargePerc;
    private Double platformChargeAmount;
    private Long outletId;
    private Integer orderQty;
    private String preparationNotes;
    private Integer status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String ipAddress;
    private String device;
    private Double sgstPerc;
    private Double cgstPerc;
    private Double sgstAmount;
    private Double cgstAmount;
    private Double roundOffAmount;

    private List<OrderItems> orderItems;

    public OrderInfo mapToEntiry() {
        return OrderInfo.builder().customerName(customerName).customerPhone(customerPhone).customerEmail(customerEmail).billAmount(billAmount).netPayableAmount(netPayableAmount).tax(tax).discountPerc(discountPerc).discountAmount(discountAmount).platformChargePerc(platformChargePerc).platformChargeAmount(platformChargeAmount).outletId(outletId).orderQty(orderQty).preparationNotes(preparationNotes).status(status).ipAddress(ipAddress).device(device).sgstPerc(sgstPerc).cgstPerc(cgstPerc).sgstAmount(sgstAmount).cgstAmount(cgstAmount).roundOffAmount(roundOffAmount).build();
    }

}
