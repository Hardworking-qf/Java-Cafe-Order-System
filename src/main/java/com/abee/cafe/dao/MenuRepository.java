package com.abee.cafe.dao;

import com.abee.cafe.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository  extends JpaRepository<Menu,Long> {
    Menu findMenuById(Long ID);

    List<Menu> findMenusByCategory(String category);

    List<Menu> findMenusByNameLike(String name);

    void deleteMenuById(Long id);

}
