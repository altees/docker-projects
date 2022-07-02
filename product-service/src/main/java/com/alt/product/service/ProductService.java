package com.alt.product.service;


import com.alt.product.entities.Product;
import com.alt.product.utilities.PaginationCriteria;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);

    Product getProduct(String productName);

    List<Product> getProducts();

    Page<Product> getProductsByPage(PaginationCriteria criteria);
}
