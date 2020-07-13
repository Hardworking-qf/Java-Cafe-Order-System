package com.abee.cafe.controller;

import com.abee.cafe.entity.User;
import com.abee.cafe.service.UserService;
import com.abee.cafe.vo.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("login")
    public User login(@RequestBody LoginRequest loginRequest) {
        return userService.login(loginRequest.getId(),
                loginRequest.getPassword());
    }

    @PostMapping
    public User addUser(@RequestBody User user) throws Exception {
            return userService.addUser(user);
    }

    @DeleteMapping
    public void deleteUser(@RequestBody User user) {
        userService.deleteUser(user);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) throws Exception {
        return userService.updateUser(user);
    }

    @GetMapping("users")
    public List<User> getAllUsers() {
        return userService.getUsers();
    }
}