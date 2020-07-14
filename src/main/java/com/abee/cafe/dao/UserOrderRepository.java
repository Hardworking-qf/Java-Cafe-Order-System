package com.abee.cafe.dao;

import com.abee.cafe.entity.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;
/*
订单ID	OrderID
用户ID	UserID
订单时间	time
订单状态	status
 */
public interface UserOrderRepository extends JpaRepository<UserOrder, Long> {

}
