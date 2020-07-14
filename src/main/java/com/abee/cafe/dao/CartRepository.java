package com.abee.cafe.dao;

import com.abee.cafe.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
/*
购物车项ID	id
用户ID	UserID
餐点ID	ItemID
数量	amount
 */
public interface CartRepository extends JpaRepository<Cart, Long> {
    void deleteCartById(Long id);

    List<Cart> findCartsByUserID(Long UserID);

    Cart findCartByUserIDAndItemID(Long UserID,Long ItemID);
}
