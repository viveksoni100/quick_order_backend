package com.quick_order.repository;

import com.quick_order.entity.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author viveksoni100
 */
@Repository
public interface OrderInfoRepository extends JpaRepository<OrderInfo, Long> {
}
