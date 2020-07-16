package com.abee.cafe.controller;


import com.abee.cafe.entity.Cart;
import com.abee.cafe.entity.User;
import com.abee.cafe.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping
    public List<Cart> getCart(@RequestBody User user) {
        return cartService.getCart(user);
    }

    @PutMapping
    public Cart updateCart(@RequestBody Cart cart) {
        return cartService.updateCart(cart);
    }

    @DeleteMapping
    public void deleteCart(@RequestBody User user){
        cartService.deleteCart(user);
    }
}
