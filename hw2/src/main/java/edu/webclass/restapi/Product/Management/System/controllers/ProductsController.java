package edu.webclass.restapi.Product.Management.System.controllers;

import edu.webclass.restapi.Product.Management.System.models.Product;
import edu.webclass.restapi.Product.Management.System.models.dto.ProductDto;
import edu.webclass.restapi.Product.Management.System.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.InstanceNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductsController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable("id") String id) throws InstanceNotFoundException {
        return productService.findProductById(id);
    }

    @GetMapping("/list")
    public List<ProductDto> listAllProducts() {
        return productService.findAllProducts().stream().map(ProductDto::new).toList();
    }

    @PostMapping("/add")
    public boolean addProduct(@RequestHeader("name") String title, @RequestHeader String brand, @RequestHeader int price) {
        return productService.addProduct(title, brand, price);
    }

}
