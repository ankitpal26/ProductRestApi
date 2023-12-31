package com.rest.api.Product.controller;

import com.rest.api.Product.entity.Product;
import com.rest.api.Product.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    //create
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product product1 = this.productService.create(product);
        return  new ResponseEntity<>(product1, HttpStatus.CREATED);
    }

    //update
    @PutMapping("/{productId}")
    public  ResponseEntity<Product> updateProduct(@RequestBody Product product,@PathVariable int productId){
        Product product1=this.productService.update(product,productId);
        return new ResponseEntity<>(product1,HttpStatus.CREATED);
    }
    //delete

    @DeleteMapping("/{productId}")
    public ResponseEntity<Map<String,String>> deleteProduct(@PathVariable int productId){
        this.productService.delete(productId);
        Map<String,String> message = Map.of("message","Product deleted successfully");
        return new ResponseEntity<>( message,HttpStatus.OK);
    }

    //get single product

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable int productId){
        Product product= this.productService.getById(productId);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    //get all product
    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct(){
        List<Product> list = this.productService.getAll();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }



}
