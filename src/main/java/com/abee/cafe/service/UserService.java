package com.abee.cafe.service;

import com.abee.cafe.dao.UserRepository;
import com.abee.cafe.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByTelephone(String telephone) {
        return userRepository.findUserByTelephone(telephone);
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }
}
