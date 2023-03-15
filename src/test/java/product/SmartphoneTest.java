package product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SmartphoneTest {
    Smartphone smartphone = new Smartphone(1, "phone", 100_000, "samsung");
    Book book = new Book(5, "book", 100_000, "Alexander");
    Product product = new Product(9, "player", 100_000);
    @Test
    public void matchesValidTest(){
        Assertions.assertEquals(true,smartphone.matches("samsung"));
    }
    @Test
    public void matchesNotValidTest(){
        Assertions.assertEquals(false,smartphone.matches("player"));
    }
    @Test
    public void matchesValidCheck(){
        Assertions.assertEquals(true,smartphone.matches("ung"));
    }
    @Test
    public void matchesNotValidCheck(){
        Assertions.assertEquals(false,smartphone.matches("Sam"));
    }
}