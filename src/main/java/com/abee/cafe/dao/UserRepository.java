package com.abee.cafe.dao;

import com.abee.cafe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByTelephone(String telephone);

    void deleteUserByTelephone(String telephone);
}
