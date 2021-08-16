package com.alt.product.repositories;

import com.alt.product.entities.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String> {

    Product findByProductName(String productName);
}
