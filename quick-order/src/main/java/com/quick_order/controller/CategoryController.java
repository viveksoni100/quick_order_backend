package com.quick_order.controller;

import com.quick_order.dto.AddCategoryRequest;
import com.quick_order.dto.AddItemRequest;
import com.quick_order.entity.Categories;
import com.quick_order.entity.Items;
import com.quick_order.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/getAllByMenuId/{menuId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @Operation(
            summary = "Get all categories by menu id",
            description = "Requires USER or ADMIN role.",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    public ResponseEntity<List<Categories>> getAllByMenuId(@PathVariable Integer menuId) {
        return ResponseEntity.ok(service.getAllByMenuId(menuId));
    }

    @GetMapping("/getById/{categoryId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @Operation(
            summary = "Get a category by id",
            description = "Requires USER or ADMIN role.",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    public ResponseEntity<Categories> getById(@PathVariable Integer categoryId) {
        return ResponseEntity.ok(service.getById(categoryId));
    }

    @DeleteMapping("/removeById/{categoryId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @Operation(
            summary = "Remove a category by id",
            description = "Requires USER or ADMIN role.",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    public ResponseEntity<String> removeById(@PathVariable Integer categoryId) {
        return ResponseEntity.ok(service.removeById(categoryId));
    }

    @PatchMapping("/edit")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @Operation(
            summary = "Edit a category",
            description = "Requires USER or ADMIN role.",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    public ResponseEntity<String> editCategory(@RequestBody AddCategoryRequest request) {
        return ResponseEntity.ok(service.editCategory(request));
    }

}
