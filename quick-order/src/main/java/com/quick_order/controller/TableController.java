package com.quick_order.controller;

import com.quick_order.dto.AddTableRequest;
import com.quick_order.entity.TableInfo;
import com.quick_order.service.TableService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author viveksoni100
 */
@RestController
@RequestMapping("/api/table")
@RequiredArgsConstructor
public class TableController {

    private final TableService service;

    @PostMapping("/add")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @Operation(
            summary = "Add a new Table",
            description = "Requires USER or ADMIN role.",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    public ResponseEntity<String> addTable(@RequestBody AddTableRequest request) {
        return ResponseEntity.ok(service.addTable(request));
    }

    @GetMapping("/getAllByOutletId/{outletId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @Operation(
            summary = "Get all Table by menu id",
            description = "Requires USER or ADMIN role.",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    public ResponseEntity<List<TableInfo>> getAllByOutletId(@PathVariable Integer outletId) {
        return ResponseEntity.ok(service.getAllByOutletId(outletId));
    }

    @GetMapping("/getById/{tableId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @Operation(
            summary = "Get a Table by id",
            description = "Requires USER or ADMIN role.",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    public ResponseEntity<TableInfo> getById(@PathVariable Integer tableId) {
        return ResponseEntity.ok(service.getById(tableId));
    }

    @DeleteMapping("/removeById/{tableId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @Operation(
            summary = "Remove a Table by id",
            description = "Requires USER or ADMIN role.",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    public ResponseEntity<String> removeById(@PathVariable Integer tableId) {
        return ResponseEntity.ok(service.removeById(tableId));
    }

    @PatchMapping("/edit")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @Operation(
            summary = "Edit a Table",
            description = "Requires USER or ADMIN role.",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    public ResponseEntity<String> editTable(@RequestBody AddTableRequest request) {
        return ResponseEntity.ok(service.editTable(request));
    }

}
