package com.abee.cafe.entity;

import lombok.Data;

import java.util.List;

@Data
public class OrderSearchResultList {
    private Long OrderID;

    private Long UserID;

    private String UserName;

    private Long time;

    private String status;

    private List<OrderSearchResult> list;
}

class OrderSearchResult{
    private Long id;

    private Long ItemID;

    private String ItemName;

    private String describe;

    private String category;

    private Long amount;

    private float price;

    private String url;
}
