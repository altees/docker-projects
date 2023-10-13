package com.alt.user.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("product-service")
public interface ProductFeignClient {

    @GetMapping("/product/products")
    public List<Product> getProducts();

}
