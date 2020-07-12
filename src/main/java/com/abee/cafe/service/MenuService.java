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

    @Transactional(rollbackFor=Exception.class)
    public List<Menu> getAll(){
        return menuRepository.findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Menu> getByCategory(String category){
        return menuRepository.findMenusByCategory(category);
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Menu> getByNameLike(String name){
        return menuRepository.findMenusByNameLike(name);
    }

    @Transactional(rollbackFor = Exception.class)
    public Menu addMenu(Menu menu){
        System.out.println(menu.getName());
        if(menuRepository.findMenuById(menu.getId())==null)return menuRepository.save(menu);
        else return null;
    }
    @Transactional(rollbackFor = Exception.class)
    public Menu updateMenu(Menu menu){
        if(menuRepository.findMenuById(menu.getId())!=null)return menuRepository.save(menu);
        else return null;
    }
    @Transactional(rollbackFor = Exception.class)
    public void deleteMenu(Menu menu){
        menuRepository.deleteMenuById(menu.getId());
    }

    public Token getToken(){
        //test
        String accessKey = "pjFykFd0F6fh04SttkLiGKGBHLVq--hzJJoBoVSd";
        String secretKey = "k6CK4XQpEhC85YjqWOOZUvIbBcCdmoCCWDGXRqSh";
        String bucket = "java-big-homework-pic";
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        System.out.println("this is token:\n*********\n******\n"+upToken);
        //test
        return new Token(upToken);
    }
}
