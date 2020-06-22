package com.abee.cafe.controller;

import com.abee.cafe.entity.User;
import com.abee.cafe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User addUser(User user) {
        return userService.addUser(user);
    }

    @GetMapping("telephone")
    public User findByTelephone(String telephone) {
        return userService.findByTelephone(telephone);
    }

    @GetMapping("test/add")
    public User addUser() {
        User user = new User();
        user.setUsername("username");
        user.setPassword("password");
        user.setTelephone("13300000000");
        user.setEmail("test@foxmail.com");
        user.setAdmin(false);

        return userService.addUser(user);
    }

    @GetMapping("test/delete")
    public void deleteUser() {
        User user = new User();
        user.setUsername("username");
        user.setPassword("password");
        user.setTelephone("13300000000");
        user.setEmail("test@foxmail.com");
        user.setAdmin(false);
        userService.deleteUser(user);
    }

    @GetMapping("test/update")
    public User updateUser() {
        User user = new User();
        user.setUsername("username-update");
        user.setPassword("password-update");
        user.setTelephone("13300000000");
        user.setEmail("test@foxmail.com");
        user.setAdmin(false);
        return userService.updateUser(user);
    }
}
