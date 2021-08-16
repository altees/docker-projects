package com.alt.user.controller;

import com.alt.user.domain.User;
import com.alt.user.feignClient.Product;
import com.alt.user.feignClient.ProductFeignClient;
import com.alt.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    ProductFeignClient productFeignClient;
    @Autowired
    private UserService userService;

    private User registerUer(User user) {
        return userService.registerUser(user);
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productFeignClient.getProducts();
    }
}
