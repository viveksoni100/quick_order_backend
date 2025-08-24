package com.quick_order.service;

import com.quick_order.dto.CreateOrderRequest;
import com.quick_order.entity.OrderInfo;
import com.quick_order.entity.OrderItems;
import com.quick_order.entity.Outlet;
import com.quick_order.enums.OrderStatusEnum;
import com.quick_order.repository.OrderInfoRepository;
import com.quick_order.repository.OrderItemsRepository;
import com.quick_order.repository.OutletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author viveksoni100
 */
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderInfoRepository orderRepository;
    private final OutletRepository outletRepository;
    private final OrderItemsRepository orderItemsRepository;

    public String createAnOrderWithCalculation(CreateOrderRequest request) throws Exception {
        OrderInfo order = new OrderInfo();
        Double billAmount = request.getBillAmount();
        Double netPayableAmount = 0.0;

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
        order.setTax(null); // provision for extra tax

        double discountAmount = billAmount * outletSettings.get().getDiscount();
        order.setDiscountPerc(outletSettings.get().getDiscount());
        order.setDiscountAmount(discountAmount);

        double platformChargeAmount = billAmount * outletSettings.get().getPlatformCharge();
        order.setPlatformChargePerc(outletSettings.get().getPlatformCharge());
        order.setPlatformChargeAmount(platformChargeAmount);

        double sgstAmount = billAmount * outletSettings.get().getSgst();
        order.setSgstPerc(outletSettings.get().getSgst());
        order.setSgstAmount(sgstAmount);

        double cgstAmount = billAmount * outletSettings.get().getCgst();
        order.setCgstPerc(outletSettings.get().getCgst());
        order.setCgstAmount(cgstAmount);
        /*
          net payable amount to be calculated
           netPayableAmount = ((billAmount - discountAmount) + (platformChargeAmount + sgstAmount + cgstAmount))
         */
        netPayableAmount = ((billAmount - discountAmount) + (platformChargeAmount + sgstAmount + cgstAmount));
        order.setBillAmount(billAmount);

        double roundOffAmount = doTheRoundOff(netPayableAmount);

        roundOffAmount = netPayableAmount - roundOffAmount;
        order.setRoundOffAmount(roundOffAmount);
        order.setNetPayableAmount(netPayableAmount - roundOffAmount);

        order.setOutletId(request.getOutletId());
        order.setOrderQty(request.getOrderQty());
        order.setPreparationNotes(request.getPreparationNotes());
        order.setStatus(OrderStatusEnum.RECEIVED.getId());
        order.setIpAddress(request.getIpAddress());
        order.setDevice(request.getDevice());

        OrderInfo createdOrder = orderRepository.save(order);

        saveOrderItems(request.getOrderItems(), createdOrder.getId());

        return "Order is placed, you're order id is: " + createdOrder.getId();
    }

    private void saveOrderItems(List<OrderItems> orderItems, long orderId) {
        orderItems.stream().forEach(item -> {
            item.setOrderId(orderId);
        });
        orderItemsRepository.saveAll(orderItems);
    }

    /**
     * do the round off
     * if netPayableAmount is not a whole number then round it to the nearest whole number
     * and return the rounded off amount
     */
    private double doTheRoundOff(Double netPayableAmount) {
        return Math.round(netPayableAmount);
    }

    public String createAnOrder(CreateOrderRequest request) {
        OrderInfo createdOrder = orderRepository.save(request.mapToEntiry());
        saveOrderItems(request.getOrderItems(), createdOrder.getId());
        return "Order is placed, you're order id is: " + createdOrder.getId();
    }
}
