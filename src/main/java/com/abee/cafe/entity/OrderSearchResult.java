package com.abee.cafe.entity;

import lombok.Data;

@Data
public class OrderSearchResult{
    private Long id;

    private Long ItemID;

    private String ItemName;

    private String describe;

    private String category;

    private Long amount;

    private float price;

    private String url;
}
