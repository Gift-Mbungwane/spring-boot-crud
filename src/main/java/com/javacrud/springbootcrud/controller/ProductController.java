package com.javacrud.springbootcrud.controller;

import com.javacrud.springbootcrud.entity.Product;
import com.javacrud.springbootcrud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    //Controller for posting
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
     return service.saveProduct(product);
    }

    //Controller to save a list of product
    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products){
        return service.saveProducts(products);
    }

    //Controller for getting a product
    @GetMapping("/products")
    public List<Product> findAllProduct(){
        return service.getProduct();
    }

    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @GetMapping("/products/{name}")
    public Product findProductByName(@PathVariable String name) {
        return service.getProductByName(name);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product){
        return service.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@RequestBody int id){
        return service.deleteProductById(id);
    }

}
