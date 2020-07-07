package com.abee.cafe.dao;

import com.abee.cafe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserById(Long id);

    User findUserByTelephone(String telephone);

    User findUserByEmail(String email);

    User findUserByUsername(String username);

    void deleteUserByUsernameAndPassword(String username, String password);

    void deleteUserByEmailAndPassword(String email, String password);

    void deleteUserByTelephoneAndPassword(String telephone, String password);

}