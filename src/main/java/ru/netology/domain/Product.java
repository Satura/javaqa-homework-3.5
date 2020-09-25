package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
//@NoArgsConstructor
@Setter
@Getter

public class Product {
    private int id;
    private String name;
    private int cost;

    public boolean matches(String search){
        return name.equalsIgnoreCase(search);
    }
}
