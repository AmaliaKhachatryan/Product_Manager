package product;

public class RepositoryProduct {
    private Product[] products = new Product[0];

    public Product[] findAll() {
        return products;
    }

    public void save(Product product) {
        if (findById(product.getId()) != null) {
            throw new AlreadyExistsException(product.getId());
        }

        Product[] result = new Product[products.length + 1];
        int i = 0;
        while (i < products.length) {
            result[i] = products[i];
            i++;
        }
        result[result.length - 1] = product;
        products = result;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException(id);
        }
        Product[] result = new Product[products.length - 1];
        int count = 0;
        for (Product prod : products) {
            if (prod.getId() != id) {
                result[count] = prod;
                count++;
            }

        }
        products = result;
    }

    public Product findById(int id) {
        for (Product prod : products) {
            if (prod.getId() == id) {
                return prod;
            }
        }
        return null;
    }
}