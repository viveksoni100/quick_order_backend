package com.quick_order.repository;

import com.quick_order.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author viveksoni100
 */
@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {
    Optional<Menu> findByUserId(Long userId);
}
