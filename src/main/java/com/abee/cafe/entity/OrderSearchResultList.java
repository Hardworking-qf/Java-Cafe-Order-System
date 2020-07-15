package com.abee.cafe.entity;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class OrderSearchResultList {
    private Long orderID;

    private Long userID;

    private Timestamp time;

    private String orderStatus;

    private List<OrderSearchResult> list;
}
