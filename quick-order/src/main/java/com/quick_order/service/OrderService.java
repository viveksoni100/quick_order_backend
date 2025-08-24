package com.quick_order.service;

import com.quick_order.dto.CreateOrderRequest;
import com.quick_order.entity.OrderInfo;
import com.quick_order.repository.OrderInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author viveksoni100
 */
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderInfoRepository repository;

    public String createAnOrder(CreateOrderRequest request) {
        OrderInfo order = new OrderInfo();

        order.setCustomerName(request.getCustomerName());
        order.setCustomerPhone(request.getCustomerPhone());
        order.setCustomerEmail(request.getCustomerEmail());
        /**
         * billAmount to be calculated
         */
        order.setBillAmount(null);
        order.setTax(null);
        order.setDiscountPerc(null);
        order.setDiscountAmount(null);
        order.setPlatformChargePerc(null);
        order.setPlatformChargeAmount(null);
        order.setOutletId(null);
        order.setOrderQty(null);
        order.setPreparationNotes(null);
        order.setStatus(null);
        order.setIpAddress(null);
        order.setDevice(null);
        order.setSgstPerc(null);
        order.setSgstAmount(null);
        order.setCgstPerc(null);
        order.setCgstAmount(null);
        order.setRoundOffAmount(null);

        OrderInfo createdOrder = repository.save(order);
        return "Order is placed, you're order id is: " + createdOrder.getId();
    }
}
