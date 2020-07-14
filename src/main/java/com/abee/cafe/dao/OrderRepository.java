package com.abee.cafe.dao;

import com.abee.cafe.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*
订单项ID	id
订单ID	OrderID
餐点ID	ItemID
餐点数量	amount
餐点单价	price
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
    //List<Order> findOrdersByOrderID(Long OrderID);
}
