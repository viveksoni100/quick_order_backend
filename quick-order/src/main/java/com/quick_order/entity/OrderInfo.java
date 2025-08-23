package com.quick_order.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author viveksoni100
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_info")
public class OrderInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private String customerPhone;
    private String customerEmail;
    private Double billAmount;
    private Double tax;
    private Double discountPerc;
    private Double discountAmount;
    private Double platformChargePerc;
    private Double platformChargeAmount;
    private Integer outletId;
    private Integer orderQty;
    private String preprationNotes;
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

}
