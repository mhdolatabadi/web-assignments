package edu.webclass.restapi.Product.Management.System.repository;

import edu.webclass.restapi.Product.Management.System.models.Product;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.management.InstanceNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductRepository {

    public static ArrayList<Product> products = new ArrayList<>();
    public static int lastIndex = 0;

    public ProductRepository() {
        products.add(new Product("Mobile", "Samsung", 50000000));
        products.add(new Product("Cacke", "TITOP!", 10000));
    }

    public boolean createNewProduct(Product product) {
        products.add(product);
        return ProductRepository.lastIndex == ProductRepository.products.size();
    }

    public List<Product> findAllProducts() {
        return products;
    }

    public Product findProductById(String id) throws InstanceNotFoundException {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        throw new InstanceNotFoundException("Product with given id not found");
    }

}
