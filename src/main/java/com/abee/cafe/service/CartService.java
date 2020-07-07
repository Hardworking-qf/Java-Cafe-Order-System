package com.abee.cafe.service;

import com.abee.cafe.dao.CartRepository;
import com.abee.cafe.entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CartService {
    @Autowired
    private CartRepository cartRepository;

    @Transactional(rollbackFor = Exception.class)
    public Cart addCart(Cart cart){
        return cartRepository.save(cart);
    }
    @Transactional(rollbackFor = Exception.class)
    public Cart updateCart(Cart cart){
        return cartRepository.save(cart);
    }
    @Transactional(rollbackFor = Exception.class)
    public void deleteCart(Cart cart){
        cartRepository.deleteCartById(cart.getId());
    }
}
