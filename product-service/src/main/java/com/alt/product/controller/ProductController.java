package com.alt.product.controller;

import com.alt.product.entities.Product;
import com.alt.product.service.ProductService;
import com.alt.product.utilities.PaginationCriteria;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(value = "http://localhost:3000")
@RequestMapping("/admin")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;


    @PostMapping("/product")
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);

    }

    @GetMapping("/products")
    public List<Product> getProducts(){ log.trace("Request received at controller");

          //
         //
        return productService.getProducts();
    }

    @GetMapping("/product/{productName}")
    public Product getProduct(@PathVariable String productName){

        return productService.getProduct(productName);
    }


    @PostMapping("/products/page")
    public Page<Product> getProductsByPage(@RequestBody PaginationCriteria criteria){
        return productService.getProductsByPage(criteria);
    }







}
