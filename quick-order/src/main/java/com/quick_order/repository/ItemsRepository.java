package com.quick_order.repository;

import com.quick_order.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemsRepository extends JpaRepository<Items, Integer> {

    List<Items> findAllByMenuId(Integer menuId);

}
