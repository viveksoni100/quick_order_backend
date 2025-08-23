package com.quick_order.controller;

import com.quick_order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author viveksoni100
 */
@RestController
@RequestMapping("/api/item")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

}
