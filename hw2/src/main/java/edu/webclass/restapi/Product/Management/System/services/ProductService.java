package edu.webclass.restapi.Product.Management.System.services;

import edu.webclass.restapi.Product.Management.System.models.Product;
import edu.webclass.restapi.Product.Management.System.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.management.InstanceNotFoundException;
import java.net.http.HttpResponse;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product findProductById(String id) {
        try {
            return productRepository.findProductById(id);
        } catch (InstanceNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    public List<Product> findAllProducts() {
        return productRepository.findAllProducts();
    }

    public boolean addProduct(String title, String brand, int price) {
        return productRepository.createNewProduct(new Product(title, brand, price));
    }

}
