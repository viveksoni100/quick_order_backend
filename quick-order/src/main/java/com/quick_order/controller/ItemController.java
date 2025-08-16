package com.quick_order.controller;

import com.quick_order.dto.AddItemRequest;
import com.quick_order.entity.Items;
import com.quick_order.service.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService service;

    @PostMapping("/add")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @Operation(
        summary = "Add a new item",
        description = "Requires USER or ADMIN role.",
        security = @SecurityRequirement(name = "bearerAuth")
    )
    public ResponseEntity<String> addItem(@RequestBody AddItemRequest request) {
        return ResponseEntity.ok(service.addItem(request));
    }

    @PostMapping("/getAllByMenuId/{menuId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @Operation(
            summary = "Get all items by menu id",
            description = "Requires USER or ADMIN role.",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    public ResponseEntity<List<Items>> getAllByMenuId(@PathVariable Integer menuId) {
        return ResponseEntity.ok(service.getAllByMenuId(menuId));
    }
}
