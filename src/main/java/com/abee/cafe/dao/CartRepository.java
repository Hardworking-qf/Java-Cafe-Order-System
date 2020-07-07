package com.abee.cafe.dao;

import com.abee.cafe.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Long> {
    void deleteCartById(Long id);
    List<Cart> findCartsByUserID(Long UserID);
}
