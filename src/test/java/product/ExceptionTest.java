package product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExceptionTest {
    Smartphone product4 = new Smartphone(4, "phone", 100_000, "xxx");
    Book product5 = new Book(5, "book", 100_000, "xxx");
    Product product9 = new Product(9, "player", 100_000);
    Smartphone smartphone = new Smartphone(1, "phone", 100_000, "samsung");
    Book book = new Book(5, "book", 100_000, "Alexander");
    Product product = new Product(9, "player", 100_000);
    RepositoryProduct repo = new RepositoryProduct();
    ProductManager manager = new ProductManager(repo);

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
}
