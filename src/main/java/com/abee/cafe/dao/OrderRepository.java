package com.abee.cafe.dao;

import com.abee.cafe.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
    //List<Order> findOrdersByUserIDOrderByOrderID(Long UserID);
}
