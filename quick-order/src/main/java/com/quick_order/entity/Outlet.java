package com.quick_order.entity;

import jakarta.persistence.*;
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
@Entity
@Table(name = "outlet")
public class Outlet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String name;
    private String address;
    private String city;
    private String state;
    private String country;
    private String pin_code;

    private Double tax;
    private Double discount;
    private Double platformCharge;
    private Double sgst;
    private Double cgst;

    private Integer businessType;

}
