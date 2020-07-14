package com.abee.cafe.dao;

import com.abee.cafe.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
/*
餐点ID	id
餐点名称	name
餐点描述	describe
餐点类型	category
库存数量	amount
单价	price
是否上架	selling
图片URL	icon
 */

public interface MenuRepository extends JpaRepository<Menu, Long> {
    Menu findMenuById(Long ID);

    List<Menu> findMenusByCategory(String category);

    List<Menu> findMenusByNameLike(String name);

    void deleteMenuById(Long id);

}
