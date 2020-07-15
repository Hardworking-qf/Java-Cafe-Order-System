package com.abee.cafe.entity;

import lombok.Data;

@Data
public class OrderSearchResult{
    private Long id;

    private Long menuID;

    private String itemName;

    private String description;

    private String category;

    private Long amount;

    private float price;

    private String icon;
}
