package com.quick_order.service;

import com.quick_order.dto.CreateOrderRequest;
import com.quick_order.entity.OrderInfo;
import com.quick_order.enums.OrderStatusEnum;
import com.quick_order.repository.OrderInfoRepository;
import com.quick_order.repository.OutletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author viveksoni100
 */
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderInfoRepository orderRepository;
    private final OutletRepository outletRepository;

    public String createAnOrder(CreateOrderRequest request) {
        OrderInfo order = new OrderInfo();

        order.setCustomerName(request.getCustomerName());
        order.setCustomerPhone(request.getCustomerPhone());
        order.setCustomerEmail(request.getCustomerEmail());
        /**
         * outlet specific values
         */
        outletRepository.findById(request.getOutletId());

        order.setTax(null);
        order.setDiscountPerc(null);
        order.setDiscountAmount(null);
        order.setPlatformChargePerc(null);
        order.setPlatformChargeAmount(null);
        order.setSgstPerc(null);
        order.setSgstAmount(null);
        order.setCgstPerc(null);
        order.setCgstAmount(null);
        /**
         * billAmount to be calculated
         */
        order.setRoundOffAmount(null);
        order.setBillAmount(null);

        order.setOutletId(request.getOutletId());
        order.setOrderQty(request.getOrderQty());
        order.setPreparationNotes(request.getPreparationNotes());
        order.setStatus(OrderStatusEnum.RECEIVED.getId());
        order.setIpAddress(request.getIpAddress());
        order.setDevice(request.getDevice());

        OrderInfo createdOrder = orderRepository.save(order);
        return "Order is placed, you're order id is: " + createdOrder.getId();
    }
}
