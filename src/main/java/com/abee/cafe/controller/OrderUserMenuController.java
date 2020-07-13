package com.abee.cafe.controller;

import com.abee.cafe.service.OrderUserMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("orderusermenu")
public class OrderUserMenuController {
    @Autowired
    private OrderUserMenuService menuService;
}
