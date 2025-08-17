package com.quick_order.controller;

import com.quick_order.entity.Items;
import com.quick_order.service.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author viveksoni100
 */
@RestController
@RequestMapping("/api/outlet")
@RequiredArgsConstructor
public class OutletController {

    private final ItemService itemService;

    @GetMapping("/getAllItemsByMenuId/{menuId}")
    @Operation(
            summary = "Get all items by menu id for outlet"
    )
    public ResponseEntity<List<Items>> getAllItemsByMenuId(@PathVariable Integer menuId) {
        return ResponseEntity.ok(itemService.getAllByMenuId(menuId));
    }

}
