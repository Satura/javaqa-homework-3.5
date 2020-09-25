package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepositry;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepositry repositry = new ProductRepositry();
    private ProductManager manager = new ProductManager(repositry);

    private Product product_1 = new Product(1, "product1", 150);
    private Product product_2 = new Product(2, "product2", 120);
    private Product product_3 = new Product(3, "product3", 350);
    private Book book1 = new Book(4,"book1", 450, "author1");
    private Book book2 = new Book(5,"book2", 450, "author1");
    private Book book3 = new Book(6,"book3", 450, "author2");
    private Smartphone phone1 = new Smartphone(7,"phone1", 1700, "brand1");
    private Smartphone phone2 = new Smartphone(8,"phone2", 1350, "brand2");
    private Smartphone phone3 = new Smartphone(9,"phone3", 2500, "brand3");

    @BeforeEach
    void setUp() {
        manager.add(product_1);
        manager.add(product_2);
        manager.add(product_3);
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);
    }

    @Test
    void add() {
        Product product_4 = new Product(10,"product_4",10);
        manager.add(product_4);
        Product[] expected = new Product[]{product_1,product_2,product_3,book1,book2,book3,phone1,phone2,phone3,product_4};
        Product[] actual = repositry.findAll();
        assertArrayEquals(expected,actual);
    }

    @Test
    void shouldSearchBookByAuthor() {
        Product[] expected = new Product[]{book1,book2};
        Product[] actual = manager.searchBy("author1");
        assertArrayEquals(expected,actual);
    }
    @Test
    void shouldSearchBookByName() {
        Product[] expected = new Product[]{book1};
        Product[] actual = manager.searchBy("book1");
        assertArrayEquals(expected,actual);
    }
    @Test
    void shouldNotSearchBy() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("noname");
        assertArrayEquals(expected,actual);
    }
    @Test
    void shouldSearchPhoneByBrand() {
        Product[] expected = new Product[]{phone2};
        Product[] actual = manager.searchBy("brand2");
        assertArrayEquals(expected,actual);
    }
    @Test
    void shouldSearchPhoneByName() {
        Product[] expected = new Product[]{phone1};
        Product[] actual = manager.searchBy("phone1");
        assertArrayEquals(expected,actual);
    }
    @Test
    void shouldSearchByName() {
        Product[] expected = new Product[]{product_1};
        Product[] actual = manager.searchBy("product1");
        assertArrayEquals(expected,actual);
    }

    @Test
    void shouldMatches() {
        assertTrue (manager.matches(phone1,"brand1"));
    }
    @Test
    void shouldNotMatches() {
        assertFalse (manager.matches(phone1,"brand0"));
    }
}