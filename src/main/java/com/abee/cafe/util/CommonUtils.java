package com.abee.cafe.util;

import org.springframework.util.DigestUtils;

public class CommonUtils {

    public static String password2Db(String password) {
        return DigestUtils.md5DigestAsHex(password.getBytes());
    }

    public static boolean isEmail(String mail) {
        if (mail != null) {
            return mail.contains("@");
        } else {
            return false;
        }
    }

    public static boolean isTelephoneNumber(String number) {
        return number.matches("[0-9]{11}");
    }
}
