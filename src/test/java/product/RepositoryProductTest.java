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
    Smartphone smartphone = new Smartphone(1, "phone", 100_000, "samsung");
    Book book = new Book(5, "book", 100_000, "Alexander");
    Product product = new Product(9, "player", 100_000);
    Product product9 = new Product(9, "player", 100_000);
    Product product10 = new Product(10, "player", 100_000);

    RepositoryProduct repo = new RepositoryProduct();
    @Test
    public  void removeWithoutArrayTest(){
        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(25);
        });
    }
    @Test
    public  void removeWithOneProductTest(){
        repo.save(book);
        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(smartphone.getId());
        });
    }
    @Test
    public  void removeProductByIdTest(){
        repo.save(book);
        repo.save(smartphone);
        repo.removeById(book.getId());
        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(book.getId());
        });
    }
    @Test
    public  void removeProductsTest(){
        repo.save(book);
        repo.save(smartphone);
        repo.save(product);
        repo.removeById(book.getId());
        Product[] expected={smartphone,product};
        Assertions.assertArrayEquals(expected,repo.findAll());
    }

    @Test
    public  void removeProductThenIdMinusTest(){
        repo.save(book);
        repo.save(smartphone);
        repo.save(product);
        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(-1);
        });
    }
    @Test
    public  void removeProductThenIdZeroTest(){
        repo.save(book);
        repo.save(smartphone);
        repo.save(product);
        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(0);
        });
    }
    @Test
    public  void saveProductExceptionTest(){
        repo.save(book);
        repo.save(smartphone);
        repo.save(product);
        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.save(product);
        });
    }
    @Test
    public  void saveFirstProductTest(){
        repo.save(book);
        repo.save(smartphone);
        repo.save(product);
        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.save(book);
        });
    }
    @Test
    public  void saveProductTest(){
        repo.save(book);
        repo.save(smartphone);
        repo.save(product);
        Product[] expected={book,smartphone,product};
        Assertions.assertArrayEquals(expected,repo.findAll());
    }

    @Test
    public void findAllTest() {
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.save(product5);
        repo.save(product6);
              Product[] extend = {product1,product2,product3,product4,product5,product6};
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
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.save(product5);
        repo.save(product6);
        repo.save(product9);
        repo.save(product10);
        repo.removeById(3);
        Product[] extend = {product1,product2,product4,product5,product6,product9,product10};
        Assertions.assertArrayEquals(extend, repo.findAll());
    }
    @Test
    public void deleteAllTest(){
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.removeById(1);
        repo.removeById(2);
        repo.removeById(3);
        Product[] extend = {};
        Assertions.assertArrayEquals(extend, repo.findAll());
    }

}