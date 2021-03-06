package com.abee.cafe.service;

import com.abee.cafe.dao.MenuRepository;
import com.abee.cafe.entity.Menu;
import com.abee.cafe.entity.Token;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MenuService {

    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    // 获取全部菜单
    @Transactional(rollbackFor = Exception.class)
    public List<Menu> getAll() {
        return menuRepository.findAll();
    }

    // 根据食品种类获取菜单
    @Transactional(rollbackFor = Exception.class)
    public List<Menu> getByCategory(String category) {
        return menuRepository.findMenusByCategory(category);
    }

    // 模糊搜索
    @Transactional(rollbackFor = Exception.class)
    public List<Menu> getByNameLike(String name) {
        return menuRepository.findMenusByNameLike(name);
    }

    // 增加菜单项
    @Transactional(rollbackFor = Exception.class)
    public Menu addMenu(Menu menu) {
        System.out.println(menu.getName());
        if (menuRepository.findMenuById(menu.getId()) == null) return menuRepository.save(menu);
        else return null;
    }

    // 更新菜单项
    @Transactional(rollbackFor = Exception.class)
    public Menu updateMenu(Menu menu) {
        if (menuRepository.findMenuById(menu.getId()) != null) return menuRepository.save(menu);
        else return null;
    }

    // 删除菜单项
    @Transactional(rollbackFor = Exception.class)
    public void deleteMenu(Menu menu) {
        menuRepository.deleteMenuById(menu.getId());
    }

    // 获取token 图床用
    public Token getToken(Menu menu) {
        //test
        String accessKey = "pjFykFd0F6fh04SttkLiGKGBHLVq--hzJJoBoVSd";
        String secretKey = "k6CK4XQpEhC85YjqWOOZUvIbBcCdmoCCWDGXRqSh";
        String bucket = "java-big-homework-pic";
        String key = menu.getIcon();

        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket, key);
        System.out.println("this is token:\n" + upToken);
        //test
        return new Token(upToken);
    }
}
