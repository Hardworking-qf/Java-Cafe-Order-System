package com.abee.cafe.service;

import com.abee.cafe.dao.*;
import com.abee.cafe.entity.Order;
import com.abee.cafe.entity.OrderUserMenu;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderUserMenuService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final MenuRepository menuRepository;
    private final OrderUserMenuRepository orderUserMenuRepository;
    private final UserOrderRepository userOrderRepository;

    public OrderUserMenuService(
            OrderRepository orderRepository,
            UserRepository userRepository,
            MenuRepository menuRepository,
            OrderUserMenuRepository orderUserMenuRepository,
            UserOrderRepository userOrderRepository
    ){
        this.orderRepository=orderRepository;
        this.userRepository=userRepository;
        this.menuRepository=menuRepository;
        this.orderUserMenuRepository=orderUserMenuRepository;
        this.userOrderRepository=userOrderRepository;
    }

    // 通过用户ID返回订单列表
    @Transactional(rollbackFor = Exception.class)
    List<OrderUserMenu> findOrdersByUserID(Long userID){

        return null;
    }

    // 通过用户名返回订单列表
    List<OrderUserMenu> findOrdersByUserName(String userName){

        return null;
    }

    // 通过用户邮箱返回订单列表
    List<OrderUserMenu> findOrdersByUserEmail(String userEmail){

        return null;
    }

    // 通过用户电话返回订单列表
    List<OrderUserMenu> findOrdersByUserTel(String userTel){

        return null;
    }

    // 通过订单ID返回订单
    @Transactional(rollbackFor = Exception.class)
    List<OrderUserMenu> findOrderByOrderID(Long orderID){

        return null;
    }
}
