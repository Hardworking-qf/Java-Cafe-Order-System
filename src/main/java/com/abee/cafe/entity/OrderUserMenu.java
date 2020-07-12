package com.abee.cafe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order-user-menu")
public class OrderUserMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderID;

    private Long userID;

    private Long itemID;

    private String username;

    private String name;

    private String descirbe;

    private String category;

    private Long amount;

    private float price;

    private String icon;

    private Long time;

    private String status;
}
