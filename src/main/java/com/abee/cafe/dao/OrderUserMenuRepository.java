package com.abee.cafe.dao;

import com.abee.cafe.entity.OrderUserMenu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderUserMenuRepository extends JpaRepository<OrderUserMenu, Long> {
    OrderUserMenu findOrderUserMenuByOrderID(Long OrderID);

    OrderUserMenu findOrderUserMenuByUserID(Long UserID);
}
