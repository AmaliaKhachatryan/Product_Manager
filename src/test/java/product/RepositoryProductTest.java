package product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RepositoryProductTest {
    Smartphone product1 = new Smartphone(1, "phone", 100_000, "xxx");
    Smartphone product2 = new Smartphone(2, "phone", 100_000, "xxx");
    Smartphone product3 = new Smartphone(3, "phone", 100_000, "xxx");
    Smartphone product4 = new Smartphone(4, "phone", 100_000, "xxx");
    Book product5 = new Book(5, "book", 100_000, "xxx");
    Book product6 = new Book(6, "book", 100_000, "xxx");
    Book product7 = new Book(7, "book", 100_000, "xxx");
    Book product8 = new Book(8, "book", 100_000, "xxx");
    Product product9 = new Product(9, "player", 100_000);
    Product product10 = new Product(10, "player", 100_000);

    RepositoryProduct repo = new RepositoryProduct();
    @BeforeEach
    public void setUp(){
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.save(product5);
        repo.save(product6);
        repo.save(product7);
        repo.save(product8);
        repo.save(product9);
        repo.save(product10);
    }
    @Test
    public void findAllTest() {
         Product[] extend = {product1,product2,product3,product4,product5,product6,product7,product8,product9,product10};
        Assertions.assertArrayEquals(extend, repo.findAll());

    }
    @Test
    public void findAllNullTest() {
        RepositoryProduct repo = new RepositoryProduct();
        Product[] extend = {};
        Assertions.assertArrayEquals(extend, repo.findAll());

    }
    @Test
    public void deleteByIdTest() {
        repo.deleteById(3);
        Product[] extend = {product1,product2,product4,product5,product6,product7,product8,product9,product10};
        Assertions.assertArrayEquals(extend, repo.findAll());
    }
    @Test
    public void deleteAllTest() {
        repo.deleteById(1);
        repo.deleteById(2);
        repo.deleteById(3);
        repo.deleteById(4);
        repo.deleteById(5);
        repo.deleteById(6);
        repo.deleteById(7);
        repo.deleteById(8);
        repo.deleteById(9);
        repo.deleteById(10);
        Product[] extend = {};
        Assertions.assertArrayEquals(extend, repo.findAll());
    }

}