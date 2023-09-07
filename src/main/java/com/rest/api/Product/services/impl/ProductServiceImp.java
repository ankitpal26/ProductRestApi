package com.rest.api.Product.services.impl;

import com.rest.api.Product.entity.Product;
import com.rest.api.Product.repository.ProductRepository;
import com.rest.api.Product.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public Product update(Product product, int productId) {
        Product product1 =  this.productRepository.findById(productId).orElseThrow(()-> new RuntimeException("Product not found"));
        product1.setPrice(product.getPrice());
        product1.setName(product.getName());
        product1.setAbout(product.getAbout());

        return this.productRepository.save(product1);
    }

    @Override
    public void delete(int productId) {
        Product product1 =  this.productRepository.findById(productId).orElseThrow(()-> new RuntimeException("Product not found"));
        this.productRepository.delete(product1);
    }

    @Override
    public Product getById(int productId) {
        return this.productRepository.findById(productId).orElseThrow(()-> new RuntimeException("Product not found"));
    }

    @Override
    public List<Product> getAll() {
        return this.productRepository.findAll();
    }
}
