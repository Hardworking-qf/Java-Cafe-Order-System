package com.abee.cafe.service;

import com.abee.cafe.dao.UserRepository;
import com.abee.cafe.entity.User;
import com.abee.cafe.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User login(String id, String password) {
        User user = null;

        if (CommonUtils.isEmail(id)) {
            user = userRepository.findUserByEmail(id);
        }
        if (CommonUtils.isTelephoneNumber(id)) {
            user = userRepository.findUserByTelephone(id);
        }

        if (user != null) {
            if (user.getPassword().equals(CommonUtils.password2Db(password))) {
                return user;
            }
        }

        return null;
    }

    @Transactional(rollbackFor = Exception.class)
    public User addUser(User user) {
        String password = CommonUtils.password2Db(user.getPassword());
        user.setPassword(password);
        return userRepository.save(user);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteUser(User user) {
        String password = CommonUtils.password2Db(user.getPassword());
        userRepository.deleteUserByUsernameAndPassword(user.getUsername(), password);
    }

    @Transactional(rollbackFor = Exception.class)
    public User updateUser(User user) {
        String password = CommonUtils.password2Db(user.getPassword());
        user.setPassword(password);
        return userRepository.save(user);
    }
}
