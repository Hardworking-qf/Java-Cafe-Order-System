package com.abee.cafe.entity;


import lombok.Data;

@Data
public class Token {
    String token;

    public Token(String t) {
        this.token = t;
    }
}
