package com.abee.cafe.dao;

import com.abee.cafe.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByTelephone(String telephone);

    User findUserByEmail(String email);

    void deleteUserByUsernameAndPassword(String username, String password);

}
