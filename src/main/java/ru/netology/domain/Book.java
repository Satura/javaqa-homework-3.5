package ru.netology.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Book extends Product{

    private String author;

    public Book(int id, String name, int cost,String author) {
        super(id, name, cost);
        this.author = author;
    }
}
