package product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductManagerTest {
    Smartphone product1 = new Smartphone(1, "Superphone", 100_000, "xxx");
    Smartphone product2 = new Smartphone(2, "Telephone", 100_000, "xxx");
    Smartphone product3 = new Smartphone(3, "phone", 100_000, "xxx");
    Smartphone product4 = new Smartphone(4, "phone", 100_000, "xxx");
    Book product5 = new Book(5, "book", 100_000, "xxx");
    Book product6 = new Book(6, "book", 100_000, "xxx");
    Book product7 = new Book(7, "book", 100_000, "xxx");
    Book product8 = new Book(8, "book", 100_000, "xxx");
    Product product9 = new Product(9, "player", 100_000);
    Product product10 = new Product(10, "player", 100_000);
    Smartphone smartphone = new Smartphone(1, "phone", 100_000, "samsung");
    Book book = new Book(5, "book", 100_000, "Alexander");
    Product product = new Product(9, "player", 100_000);
    RepositoryProduct repo = new RepositoryProduct();
    ProductManager manager = new ProductManager(repo);

    @BeforeEach
    public void setUp() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);
        manager.add(product6);
        manager.add(product7);
        manager.add(product8);
        manager.add(product9);
        manager.add(product10);
    }

    @Test
    void add() {
        Product[] expected = {product1, product2, product3, product4, product5, product6, product7, product8, product9, product10};
        Assertions.assertArrayEquals(expected, manager.findAll());
    }

    @Test
    void searchByPlayerTest() {
        Product[] expected = {product9, product10};
        Assertions.assertArrayEquals(expected, manager.searchBy("player"));
    }

    @Test
    void searchByBookTest() {
        Product[] expected = {product5, product6, product7, product8};
        Assertions.assertArrayEquals(expected, manager.searchBy("book"));
    }

    @Test
    void searchByPhoneTest() {
        Product[] expected = {product1, product2, product3, product4};
        Assertions.assertArrayEquals(expected, manager.searchBy("phone"));
    }

    @Test
    void searchByNotValidTest() {
        Product[] expected = {};
        Assertions.assertArrayEquals(expected, manager.searchBy("short"));
    }

    @Test
    public void matchesFalseTest() {
        Assertions.assertEquals(false, manager.matches(product1, "book"));
    }

    @Test
    public void matchesTrueTest() {
        Assertions.assertEquals(true, manager.matches(product1, "phone"));
    }

    @Test
    public void searchByOneProductTest() {
        RepositoryProduct repo = new RepositoryProduct();
        ProductManager manager = new ProductManager(repo);
        manager.add(book);
        Product[] expected = {book};
        Assertions.assertArrayEquals(expected, manager.searchBy("book"));
    }

    @Test
    public void searchByZeroProductTest() {
        RepositoryProduct repo = new RepositoryProduct();
        ProductManager manager = new ProductManager(repo);
        Product[] expected = {};
        Assertions.assertArrayEquals(expected, manager.searchBy("player"));
    }

    @Test
    public void searchBySmartphoneProductTest() {
        RepositoryProduct repo = new RepositoryProduct();
        ProductManager manager = new ProductManager(repo);
        manager.add(smartphone);
        Product[] expected = {smartphone};
        Assertions.assertArrayEquals(expected, manager.searchBy("pho"));
    }

    @Test
    public void searchBySmartphoneTest() {
        RepositoryProduct repo = new RepositoryProduct();
        ProductManager manager = new ProductManager(repo);
        manager.add(smartphone);
        Product[] expected = {};
        Assertions.assertArrayEquals(expected, manager.searchBy("book"));
    }

    @Test
    public void searchByAllProductTest() {
        RepositoryProduct repo = new RepositoryProduct();
        ProductManager manager = new ProductManager(repo);
        manager.add(smartphone);
        manager.add(book);
        manager.add(product);
        Product[] expected = {smartphone};
        Assertions.assertArrayEquals(expected, manager.searchBy("ph"));
    }
}