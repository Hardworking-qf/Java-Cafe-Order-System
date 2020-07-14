package com.abee.cafe.service;

import com.abee.cafe.dao.UserRepository;
import com.abee.cafe.entity.User;
import com.abee.cafe.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // 登录
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

    // 增加用户
    @Transactional(rollbackFor = Exception.class)
    public User addUser(User user) throws Exception {
        checkDuplicate(user);

        String password = CommonUtils.password2Db(user.getPassword());
        user.setPassword(password);
        return userRepository.save(user);
    }

    // 删除用户
    @Transactional(rollbackFor = Exception.class)
    public void deleteUser(User user) {
        String password = user.getPassword();

        if (user.getUsername() != null) {
            userRepository.deleteUserByUsernameAndPassword(user.getUsername(), password);
        }
        if (user.getEmail() != null) {
            userRepository.deleteUserByEmailAndPassword(user.getEmail(), password);
        }
        if (user.getTelephone() != null) {
            userRepository.deleteUserByTelephoneAndPassword(user.getTelephone(), password);
        }
    }

    // 更新用户
    @Transactional(rollbackFor = Exception.class)
    public User updateUser(User user) throws Exception {
        checkDuplicate(user);

        User oldUser = userRepository.findUserById(user.getId());

        if (oldUser != null) {
            if (user.getPassword() != null) {
                user.setPassword(CommonUtils.password2Db(user.getPassword()));
            } else {
                user.setPassword(oldUser.getPassword());
            }

            return userRepository.save(user);
        }
        return null;
    }

    // 模糊查找用户
    @Transactional(rollbackFor = Exception.class)
    public List<User> getUsersByFuzzySearch(String input) throws Exception {

        return null;
    }

    // 返回用户列表
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    // 验证正确性
    public void checkDuplicate(User user) throws Exception {
        if (user.getTelephone() != null) {
            User ou = userRepository.findUserByTelephone(user.getTelephone());
            if (ou != null && !ou.getId().equals(user.getId())) {
                throw new Exception("电话号码已被使用");
            }
            if (!CommonUtils.isTelephoneNumber(user.getTelephone()))
                throw new Exception("请输入正确的电话号码");
        }
        if (user.getEmail() != null) {
            User ou = userRepository.findUserByEmail(user.getEmail());
            if (ou != null && !ou.getId().equals(user.getId())) {
                throw new Exception("邮箱已被使用");
            }
            if (!CommonUtils.isEmail(user.getEmail()))
                throw new Exception("请输入正确的邮箱");
        }
        if (user.getUsername() != null) {
            User ou = userRepository.findUserByUsername(user.getUsername());
            if (ou != null && !ou.getId().equals(user.getId())) {
                throw new Exception("用户名已被使用");
            }
        }
    }

}