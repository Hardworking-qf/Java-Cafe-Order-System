package com.abee.cafe.controller;

import com.abee.cafe.entity.Menu;
import com.abee.cafe.entity.Token;
import com.abee.cafe.service.MenuService;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("token")
    public Token getToken(){
        return menuService.getToken();
    }
    @GetMapping("menus")
    public List<Menu> getAllMenus(){
        return menuService.getAll();
    }
    @PostMapping
    public Menu addMenu(@RequestBody Menu menu) throws Exception{
        menu.setId((long) -1);
        return menuService.addMenu(menu);
    }
    @DeleteMapping
    public void deleteUser(@RequestBody Menu menu){
        menuService.deleteMenu(menu);
    }
    @PutMapping
    public Menu updateMenu(@RequestBody Menu menu){
        return menuService.updateMenu(menu);
    }
}
