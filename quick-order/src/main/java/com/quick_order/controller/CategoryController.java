package com.quick_order.controller;

import com.quick_order.dto.AddCategoryRequest;
import com.quick_order.dto.AddItemRequest;
import com.quick_order.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @PostMapping("/add")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @Operation(
            summary = "Add a new category",
            description = "Requires USER or ADMIN role.",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    public ResponseEntity<String> addItem(@RequestBody AddCategoryRequest request) {
        return ResponseEntity.ok(service.addCategory(request));
    }

}
