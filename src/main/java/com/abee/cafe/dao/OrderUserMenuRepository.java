package com.abee.cafe.dao;

import com.abee.cafe.entity.OrderUserMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*
订单项ID	id
订单ID	OrderID
用户ID	UserID
餐点ID	ItemID
用户名	username
餐点名称	name
餐点描述	describe
餐点类型	category
餐点数量	amount
餐点单价	price
图片URL	icon
订单时间	time
订单状态	status
 */
public interface OrderUserMenuRepository extends JpaRepository<OrderUserMenu, Long> {
    List<OrderUserMenu> findOrderUserMenusByOrderID(Long OrderID);

    OrderUserMenu findOrderUserMenusByUserID(Long UserID);
}
