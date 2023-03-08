package product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    Smartphone smartphone = new Smartphone(1, "phone", 100_000, "samsung");
    Book book = new Book(5, "book", 100_000, "Alexander");
    Product product = new Product(9, "player", 100_000);

    @Test
    public void  matchesTest(){
        Assertions.assertEquals(false,book.matches("false"));
    }
    @Test
    public void  matchesValidTest(){
        Assertions.assertEquals(true,book.matches("Alexander"));
    }
    @Test
    public void  matchesTrueTest(){
        Assertions.assertEquals(false,book.matches("player"));
    }
    @Test
    public void  matchesTrueProductTest(){
        Assertions.assertEquals(true,product.matches("player"));
    }
}