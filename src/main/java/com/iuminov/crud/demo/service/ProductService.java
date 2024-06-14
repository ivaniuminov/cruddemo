package com.iuminov.crud.demo.service;

import com.iuminov.crud.demo.entity.Product;
import com.iuminov.crud.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> saveProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProductsById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product getProductsByName(String name) {
        return productRepository.findByName(name);
    }

    public String deleteProduct(Long id) {
        productRepository.deleteById(id);
        return "product removed";
    }

    public Product updateProduct(Product product) {
        Product existingProduct = productRepository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());

        return productRepository.save(existingProduct);
    }
}
