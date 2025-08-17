package com.quick_order.repository;

import com.quick_order.entity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author viveksoni100
 */
@Repository
public interface CategoryRepository extends JpaRepository<Categories, Integer> {

    List<Categories> findAllByMenuId(Integer menuId);

}
