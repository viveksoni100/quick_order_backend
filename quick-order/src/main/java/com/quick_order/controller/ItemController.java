package com.quick_order.controller;

import com.quick_order.dto.AuthenticationResponse;
import com.quick_order.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService service;

    /*@PostMapping("/add")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody AddItemRequest request) {
        return ResponseEntity.ok(service.addItem(request));
    }*/
}
