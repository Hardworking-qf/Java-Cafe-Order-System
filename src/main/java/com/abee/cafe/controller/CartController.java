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

    @GetMapping
    public List<Cart> getCart(@RequestBody User user) {
        return cartService.getCart(user);
    }

    @PostMapping
    public Cart addCart(@RequestBody Cart cart) {
        return cartService.updateCart(cart);
    }

    @PutMapping
    public Cart updateCart(@RequestBody Cart cart) {
        return cartService.updateCart(cart);
    }

    @DeleteMapping
    public void deleteCart(@RequestBody Cart cart){
        cartService.deleteCart(cart);
    }
}
