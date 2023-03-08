package product;


public class ProductManager {

    private RepositoryProduct repository;

    public ProductManager(RepositoryProduct repository) {
        this.repository = repository;
    }
    public void add(Product product) {
        repository.save(product);
    }
    public Product[] findAll() {
        return repository.findAll();
    }
    public Product[] searchBy(String text) {
        Product[] result = new Product[0];// тут будем хранить подошедшие запросу продукты
        RepositoryProduct repo = new RepositoryProduct();
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                repo.save(product);
            }
            result = repo.findAll();
        }
        return result;
        // "добавляем в конец" массива result продукт product
    }

    // метод определения соответствия товара product запросу search
    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
        // или в одну строку:
        //return product.getName().contains(search);
    }
}

