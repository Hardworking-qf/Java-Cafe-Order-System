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

    // 刷新购物车项，若数量为0则删除该行
    @Transactional(rollbackFor = Exception.class)
    public Cart updateCart(Cart cart) {
        if (cart.getAmount() == 0) {
            Cart newC=cartRepository.findCartByUserIDAndItemID(cart.getUserID(),cart.getItemID());
            if(newC!=null)
                cartRepository.delete(newC);
            return null;
        }
        Cart newC = cartRepository.findCartByUserIDAndItemID(cart.getUserID(), cart.getItemID());
        if (newC != null) {
            newC.setAmount(cart.getAmount());
            return cartRepository.save(newC);
        }
        return cartRepository.save(cart);
    }

    // 清空用户购物车
    @Transactional(rollbackFor = Exception.class)
    public void deleteCart(User user) {
        List<Cart> carts = cartRepository.findCartsByUserID(user.getId());
        if(carts!=null)
            cartRepository.deleteAll(carts);
    }

    // 获取某用户的购物车列表
    @Transactional(rollbackFor = Exception.class)
    public List<Cart> getCart(User user) {
        return cartRepository.findCartsByUserID(user.getId());
    }
}
