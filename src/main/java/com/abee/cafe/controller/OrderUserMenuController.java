package com.abee.cafe.controller;

import com.abee.cafe.entity.OrderSearchResult;
import com.abee.cafe.entity.OrderSearchResultList;
import com.abee.cafe.entity.OrderUserMenu;
import com.abee.cafe.entity.User;
import com.abee.cafe.service.OrderUserMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("orderusermenu")
public class OrderUserMenuController {
    @Autowired
    private OrderUserMenuService orderUserMenuService;

    @PostMapping
    public List<OrderSearchResultList> getAll() {
        return orderUserMenuService.getAll();
    }

    @PostMapping("findByID")
    public OrderSearchResultList getByID(Long ID) {
        return orderUserMenuService.findOrderByOrderID(ID);
    }

    @PostMapping("findByUser")
    public List<OrderSearchResultList> getByUser(User user){
        return orderUserMenuService.findOrdersByUser(user);
    }
}
