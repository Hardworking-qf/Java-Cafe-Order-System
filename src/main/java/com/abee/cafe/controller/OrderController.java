package com.abee.cafe.controller;


import com.abee.cafe.entity.Order;
import com.abee.cafe.entity.UserOrder;
import com.abee.cafe.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderService orderService;



    @PostMapping
    public UserOrder addOrder(@RequestBody UserOrder userOrder){
        return orderService.addUserOrder(userOrder);
    }
}
