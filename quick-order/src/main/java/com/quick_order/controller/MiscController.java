package com.quick_order.controller;

import com.quick_order.service.MiscService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author viveksoni100
 *
 */
@RestController
@RequestMapping("/api/misc")
@RequiredArgsConstructor
public class MiscController {

    private final MiscService service;

    @GetMapping("/getAllCities")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @Operation(
            summary = "Get all cities",
            description = "Requires USER or ADMIN role.",
            security = @SecurityRequirement(name = "bearerAuth")
    )
    public ResponseEntity<Map<String, Integer>> getAllCities() {
        return ResponseEntity.ok(service.getAllCities());
    }

}
