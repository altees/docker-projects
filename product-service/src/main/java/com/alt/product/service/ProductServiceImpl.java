package com.alt.product.service;

import com.alt.product.entities.Product;
import com.alt.product.repositories.ProductRepository;
import com.alt.product.utilities.PaginationCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Autowired
    private Environment environment;

    @Override
    public Product saveProduct(Product product) {

        return productRepository.save(product);
    }

    @Override
    public List<Product> getProducts() {

        PageRequest pageRequest = PageRequest.of(1, 3);
        productRepository.findAll(pageRequest);

        return productRepository.findAll();
    }

    @Override
    public Product getProduct(String productName) {
        Product byProductName = productRepository.findByProductName(productName);
        byProductName.setPortNo(Integer.parseInt(environment.getProperty("server.port")));
        return byProductName;
    }

    @Override
    public Page<Product> getProductsByPage(PaginationCriteria criteria) {
        if (criteria.getPageSize() < 1)
            return null;
        Page<Product> pageData = productRepository.findAll(PageRequest.of(criteria.getPageNumber(),criteria.getPageSize()));
        return pageData;
    }
}
