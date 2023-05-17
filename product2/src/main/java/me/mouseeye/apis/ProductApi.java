package me.mouseeye.apis;

import me.mouseeye.domain.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class ProductApi {

    private final Map<Integer, Product> products = Map.of(
            1, new Product(1, "product 1", 5),
            2, new Product(2, "product 2", 3),
            3, new Product(3, "product 3", 0)
    );

    public Product get(Integer id) {
        return products.get(id);
    }

    public List<Product> getAll() {
        return products.values().stream().toList();
    }

}
