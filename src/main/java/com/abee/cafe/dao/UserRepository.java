package com.abee.cafe.dao;

import com.abee.cafe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/*
用户ID	id
用户名	username
密码	password
电话	telephone
邮箱	email
是否管理员	is_admin
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById(Long id);

    User findUserByTelephone(String telephone);

    User findUserByEmail(String email);

    User findUserByUsername(String username);

    void deleteUserByUsernameAndPassword(String username, String password);

    void deleteUserByEmailAndPassword(String email, String password);

    void deleteUserByTelephoneAndPassword(String telephone, String password);

}