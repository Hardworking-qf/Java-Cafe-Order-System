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
