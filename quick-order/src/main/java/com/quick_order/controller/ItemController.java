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

/**
 * @author viveksoni100
 *
 */

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

    @GetMapping("/getAllByMenuId/{menuId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @Operation(
            summary = "Get all items by menu id",
            description = "Requires USER or ADMIN role.",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    public ResponseEntity<List<Items>> getAllByMenuId(@PathVariable Integer menuId) {
        return ResponseEntity.ok(service.getAllByMenuId(menuId));
    }

    @GetMapping("/getById/{itemId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @Operation(
            summary = "Get an items by id",
            description = "Requires USER or ADMIN role.",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    public ResponseEntity<Items> getById(@PathVariable Integer itemId) {
        return ResponseEntity.ok(service.getById(itemId));
    }

    @DeleteMapping("/removeById/{itemId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @Operation(
            summary = "Remove an items by id",
            description = "Requires USER or ADMIN role.",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    public ResponseEntity<String> removeById(@PathVariable Integer itemId) {
        return ResponseEntity.ok(service.removeById(itemId));
    }

    @PatchMapping("/edit")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @Operation(
            summary = "Edit an item",
            description = "Requires USER or ADMIN role.",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    public ResponseEntity<String> editItem(@RequestBody AddItemRequest request) {
        return ResponseEntity.ok(service.editItem(request));
    }

}
