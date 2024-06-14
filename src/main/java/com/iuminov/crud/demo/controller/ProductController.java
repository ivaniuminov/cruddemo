package com.iuminov.crud.demo.controller;

import com.iuminov.crud.demo.entity.Product;
import com.iuminov.crud.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProduct(@RequestBody List<Product> products) {
        return productService.saveProducts(products);
    }

    @GetMapping("/products")
    public List<Product> findProducts() {
        return productService.getProducts();
    }

    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable Long id) {
        return productService.getProductsById(id);
    }

    @GetMapping("/productByName/{name}")
    public Product findProductByName(@PathVariable String name) {
        return productService.getProductsByName(name);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }
}
