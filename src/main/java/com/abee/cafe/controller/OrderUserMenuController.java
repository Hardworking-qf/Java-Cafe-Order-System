package com.abee.cafe.controller;

import com.abee.cafe.entity.OrderSearchResult;
import com.abee.cafe.entity.OrderSearchResultList;
import com.abee.cafe.entity.OrderUserMenu;
import com.abee.cafe.entity.User;
import com.abee.cafe.service.OrderUserMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orderusermenu")
public class OrderUserMenuController {
    @Autowired
    private OrderUserMenuService orderUserMenuService;


    @GetMapping
    public List<OrderSearchResultList> getAll() {
        return orderUserMenuService.getAll();
    }

    @PostMapping("findByID")
    public OrderSearchResultList getByID(@RequestBody Long ID) {
        return orderUserMenuService.findOrderByOrderID(ID);
    }

    @PostMapping
    public List<OrderSearchResultList> getByUser(@RequestBody User user) throws  Exception{
        System.out.println(user.getId());
        return orderUserMenuService.findOrdersByUser(user);
    }
}
