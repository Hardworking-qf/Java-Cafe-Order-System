package com.abee.cafe.entity;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class OrderSearchResultList {
    private Long OrderID;

    private Long UserID;

    private String UserName;

    private Timestamp time;

    private String status;

    private List<OrderSearchResult> list;
}
