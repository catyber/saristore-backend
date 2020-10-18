package com.catdev.personalprojects.product;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductsHardcodedService {
    private static List<Product> productList = new ArrayList<Product>();
    private static long idCounter = 0;

    static {
        productList.add(new Product(++idCounter, "sweetMixByTetay", "Cheesy Baked mac"));
        productList.add(new Product(++idCounter, "sweetMixByTetay", "Custom Designed Cakes"));
        productList.add(new Product(++idCounter, "sweetMixByTetay", "Chocolate and Nuts Brownies"));
        productList.add(new Product(++idCounter, "sweetMixByTetay", "Cheese Cakes"));
        productList.add(new Product(++idCounter, "sweetMixByTetay", "Chocolate Crinckles"));
    }

    public List<Product> findAll() {
        return productList;
    }

    public Product deleteById(long id) {
        Product product = findById(id);

        if (product == null)
            return null;

        if (productList.remove(product)) {
            return product;
        }

        return null;
    }

    public Product findById(long id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
    public Product save(Product product) {
        if (product.getId() == -1 || product.getId() == 0) {
            product.setId(++idCounter);
            productList.add(product);
        } else {
            deleteById(product.getId());
            productList.add(product);
        }
        return product;
    }
}
