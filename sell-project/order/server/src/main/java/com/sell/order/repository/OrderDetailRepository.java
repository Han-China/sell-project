package com.sell.order.repository;

import com.sell.order.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administratoron 2019/3/2
 **/
@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
}
