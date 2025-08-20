package com.quick_order.repository;

import com.quick_order.entity.Items;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author viveksoni100
 */
@Registered
public interface ItemsRepository extends JpaRepository<Items, Integer> {

    List<Items> findAllByMenuIdAndIsActiveTrue(Integer menuId);
    List<Items> findAllByMenuId(Integer menuId);

}
