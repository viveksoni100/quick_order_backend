package com.quick_order.repository;

import com.quick_order.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Items, Integer> {
}
