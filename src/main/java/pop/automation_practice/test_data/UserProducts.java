package pop.automation_practice.test_data;

import java.util.ArrayList;
import java.util.List;

public class UserProducts {

    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public Double getTotalPrice() {
        Double sum = 0.0;
        for (Product product : products) {
            sum += product.getPrice();
        }
        return sum;
    }
}
