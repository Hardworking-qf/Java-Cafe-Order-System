package com.abee.cafe.service;

import com.abee.cafe.dao.CartRepository;
import com.abee.cafe.entity.Cart;
import com.abee.cafe.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;


    @Transactional(rollbackFor = Exception.class)
    public Cart updateCart(Cart cart) {
        if(cart.getAmount()==0){
            deleteCart(cart);
            return null;
        }
        Cart newC=cartRepository.findCartByUserIDAndItemID(cart.getUserID(),cart.getItemID());
        if(newC!=null) {
            newC.setAmount(cart.getAmount());
            return cartRepository.save(newC);
        }
        return cartRepository.save(cart);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteCart(Cart cart) {
        Cart newC=cartRepository.findCartByUserIDAndItemID(cart.getUserID(),cart.getItemID());
        if(newC!=null)
        cartRepository.deleteCartById(newC.getId());
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Cart> getCart(User user) {
        return cartRepository.findCartsByUserID(user.getId());
    }
}
