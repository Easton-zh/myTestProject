package com.abc.zh.study.newfeatures.lambda.ex;

import lombok.Data;

@Data
public class Item {

    private int id;

    private String name;

    private Double price;

    public Item(int id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Item() {

    }
}
