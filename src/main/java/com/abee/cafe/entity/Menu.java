package com.abee.cafe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.net.URL;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;

    private Long amount;

    private float price;

    @Column(name = "selling")
    private Boolean selling;

    private String icon;

    private String name;

    private String description;

    public Boolean validate() {
        return amount >= -1 && price >= 0.0f;
    }
}
