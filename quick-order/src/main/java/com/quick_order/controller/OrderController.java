package com.quick_order.controller;

import com.quick_order.dto.AddItemRequest;
import com.quick_order.dto.CreateOrderRequest;
import com.quick_order.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author viveksoni100
 */
@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @PostMapping("/create")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @Operation(
            summary = "Place an Order",
            description = "Requires USER or ADMIN role.",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    public ResponseEntity<String> createAnOrder(@RequestBody CreateOrderRequest request) throws Exception {
        return ResponseEntity.ok(service.createAnOrder(request));
    }
}
