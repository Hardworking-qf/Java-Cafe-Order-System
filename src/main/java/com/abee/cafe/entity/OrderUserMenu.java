package com.abee.cafe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_user_menu")
public class OrderUserMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderID;

    private Long userID;

    private Long menuID;

    private String itemname;

    private String description;

    private String category;

    private Long amount;

    private float price;

    private String icon;

    private Timestamp time;

    private String orderstatus;
}
