package com.abee.cafe.service;

import com.abee.cafe.dao.MenuRepository;
import com.abee.cafe.dao.OrderRepository;
import com.abee.cafe.dao.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderUserMenuService {
    private OrderRepository orderRepository;
    private UserRepository userRepository;
    private MenuRepository menuRepository;


}
