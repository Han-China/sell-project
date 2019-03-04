package com.sell.sellorder.repository;

import com.sell.sellorder.entity.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administratoron 2019/3/2
 **/
@Repository
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
}
