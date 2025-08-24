package com.quick_order.enums;

import java.util.Arrays;

public enum OrderStatusEnum {

    RECEIVED(1, "Received"),
    PREPARING(2, "Preparing"),
    PREPARED(3, "Prepared"),
    SERVED(4, "Served");

    private final int id;
    private final String status;

    OrderStatusEnum(int id, String status) {
        this.id = id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public static OrderStatusEnum getById(int id) {
        return Arrays.stream(OrderStatusEnum.values())
                .filter(orderStatus -> orderStatus.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public static OrderStatusEnum getByStatus(String status) {
        return Arrays.stream(OrderStatusEnum.values())
                .filter(orderStatus -> orderStatus.getStatus().equalsIgnoreCase(status))
                .findFirst()
                .orElse(null);
    }
}
