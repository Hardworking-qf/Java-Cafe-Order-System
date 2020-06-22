package com.abee.cafe.service;

import com.abee.cafe.dao.UserRepository;
import com.abee.cafe.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByTelephone(String telephone) {
        return userRepository.findUserByTelephone(telephone);
    }

    @Transactional(rollbackFor = Exception.class)
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteByTelephone(String telephone) {
        userRepository.deleteUserByTelephone(telephone);
    }

    @Transactional(rollbackFor = Exception.class)
    public User updateUser(User user) {
        return userRepository.save(user);
    }
}
