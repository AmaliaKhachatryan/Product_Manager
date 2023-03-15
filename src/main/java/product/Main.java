package product;

public class Main {
    public static void main(String[] args) throws Exception {
        Smartphone smartphone = new Smartphone(1, "phone", 100_000, "samsung");
        Book book = new Book(5, "book", 100_000, "Alexander");
        Product product = new Product(9, "player", 100_000);
        RepositoryProduct repo = new RepositoryProduct();
        repo.save(smartphone);
        repo.save(book);
       // repo.save(smartphone);
      // repo.removeById(-100);
        repo.removeById(product.getId());
    }
}

