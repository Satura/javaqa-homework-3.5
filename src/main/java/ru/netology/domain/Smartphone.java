package ru.netology.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Smartphone extends Product{

    private String brand;

    public Smartphone(int id, String name, int cost,String brand) {
        super(id, name, cost);
        this.brand = brand;
    }
}
