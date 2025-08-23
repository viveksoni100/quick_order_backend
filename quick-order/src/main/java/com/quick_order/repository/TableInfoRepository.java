package com.quick_order.repository;

import com.quick_order.entity.TableInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author viveksoni100
 */
@Repository
public interface TableInfoRepository extends JpaRepository<TableInfo, Integer> {
    List<TableInfo> findAllByOutletId(Integer outletId);
}
