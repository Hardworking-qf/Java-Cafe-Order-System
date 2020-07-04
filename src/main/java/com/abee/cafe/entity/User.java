package com.abee.cafe.entity;

import com.abee.cafe.util.CommonUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String telephone;

    private String email;

    @Column(name = "is_admin")
    private boolean admin;

    public Boolean validate() {
        if (!CommonUtils.isTelephoneNumber(telephone)) {
            return false;
        }
        if (!CommonUtils.isEmail(email)) {
            return false;
        }

        return true;
    }
}
