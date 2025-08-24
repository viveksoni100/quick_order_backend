package com.quick_order.service;

import com.quick_order.dto.CreateOrderRequest;
import com.quick_order.entity.OrderInfo;
import com.quick_order.entity.Outlet;
import com.quick_order.enums.OrderStatusEnum;
import com.quick_order.repository.OrderInfoRepository;
import com.quick_order.repository.OutletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author viveksoni100
 */
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderInfoRepository orderRepository;
    private final OutletRepository outletRepository;

    public String createAnOrder(CreateOrderRequest request) throws Exception {
        OrderInfo order = new OrderInfo();

        order.setCustomerName(request.getCustomerName());
        order.setCustomerPhone(request.getCustomerPhone());
        order.setCustomerEmail(request.getCustomerEmail());
        /*
          outlet specific values
         */
        Optional<Outlet> outletSettings = outletRepository.findById(request.getOutletId());
        if (outletSettings.isEmpty()) {
            throw new Exception("outlet settings not found");
        }
        order.setTax(null);

        order.setDiscountPerc(outletSettings.get().getDiscount());
        order.setDiscountAmount(null);

        order.setPlatformChargePerc(outletSettings.get().getPlatformCharge());
        order.setPlatformChargeAmount(null);

        order.setSgstPerc(outletSettings.get().getSgst());
        order.setSgstAmount(null);

        order.setCgstPerc(outletSettings.get().getCgst());
        order.setCgstAmount(null);
        /*
          billAmount to be calculated
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
