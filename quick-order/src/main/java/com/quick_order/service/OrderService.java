package com.quick_order.service;

import com.quick_order.repository.OrderInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author viveksoni100
 */
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderInfoRepository repository;

}
