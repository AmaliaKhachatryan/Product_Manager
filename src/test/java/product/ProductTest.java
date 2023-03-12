package product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductTest {
    Smartphone smartphone = new Smartphone(1, "phone", 100_000, "samsung");
    Book book = new Book(5, "book", 100_000, "Alexander");
    Product product = new Product(9, "player", 100_000);

    @Test
    void matches() {
        Assertions.assertEquals(false,product.matches("home"));

    }
    @Test
    void matchesValidCheck() {
        Assertions.assertEquals(true,product.matches("player"));

    }
    @Test
    void matchesValidTest() {
        Assertions.assertEquals(true,product.matches("er"));

    }
    @Test
    void matchesNotValidCheck() {
        Assertions.assertEquals(false,product.matches("Player"));

    }
  }