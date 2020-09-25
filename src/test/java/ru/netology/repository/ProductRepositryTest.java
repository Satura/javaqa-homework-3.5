package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositryTest {
    ProductRepositry repository = new ProductRepositry();

    private Product product_1 = new Product(1, "product1", 150);
    private Product product_2 = new Product(2, "product2", 120);
    private Product product_3 = new Product(3, "product3", 350);
    private Book book1 = new Book(4,"book1", 450, "author1");
    private Book book2 = new Book(5,"book2", 450, "author2");
    private Book book3 = new Book(6,"book3", 450, "author3");
    private Smartphone phone1 = new Smartphone(7,"phone1", 1700, "brand1");
    private Smartphone phone2 = new Smartphone(8,"phone2", 1350, "brand2");
    private Smartphone phone3 = new Smartphone(9,"phone3", 2500, "brand3");


    @BeforeEach
    void setUp() {
        repository.save(product_1);
        repository.save(product_2);
        repository.save(product_3);
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
        repository.save(phone1);
        repository.save(phone2);
        repository.save(phone3);
    }

    @Test
    void shouldfindAll() {
        Product[] expected = new Product[]{product_1,product_2,product_3,book1,book2,book3,phone1,phone2,phone3};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected,actual);
    }

    @Test
    void shouldRemoveById() {
        repository.removeById(3);
        Product[] expected = new Product[]{product_1,product_2,book1,book2,book3,phone1,phone2,phone3};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected,actual);
    }

    @Test
    void shouldNotRemoveById() {
        repository.removeById(30);
        Product[] expected = new Product[]{product_1,product_2,product_3,book1,book2,book3,phone1,phone2,phone3};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected,actual);
    }

    @Test
    void shouldSave() {
        Product product_4 = new Product(10,"product_4",10);
        repository.save(product_4);
        Product[] expected = new Product[]{product_1,product_2,product_3,book1,book2,book3,phone1,phone2,phone3, product_4};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected,actual);
    }
}