package com.javacrud.springbootcrud.service;

import com.javacrud.springbootcrud.entity.Product;
import com.javacrud.springbootcrud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    //posting a single products
    public Product saveProduct(Product product){
        return repository.save(product);
    }
    //Posting to Product into database (multiple products)
    public List<Product> saveProducts(List<Product> products){
        return repository.saveAll(products);
    }
    //getting all products available on DB
    public List<Product> getProduct(){
        return repository.findAll();
    }
    //Getting all products with the user ID
    public Product getProductById(int id){
        return repository.findById(id).orElse(null);
    }
    //Getting details of the user by name
    public Product getProductByName(String name){
        return repository.findByName(name);
    }

    //Removing a single product by id
    public String deleteProductById(int id){
        repository.deleteById(id);
        return "Product removed by" + id;
    }

    //updating product base on provided id
    public Product updateProduct(Product product) {
        //firstly get the existing product by id
        Product existingProduct = repository.findById(product.getId()).orElse(null);
        //updating the existing
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());
        //then save the existing
        return repository.save(existingProduct);
    }

}
