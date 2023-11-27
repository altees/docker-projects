package com.altess.AccountMS.controller;

import com.altess.AccountMS.entity.User;
import com.altess.AccountMS.request.SignUpByEmailRequest;
import com.altess.AccountMS.response.BaseResponse;
import com.altess.AccountMS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/bmusers")
public class AccountController {


    private final UserService userService;

    @Autowired
    public AccountController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public Mono<ResponseEntity<BaseResponse>> saveUser(@Valid @RequestBody Mono<SignUpByEmailRequest> singUpRequest) {
        return singUpRequest.flatMap(request -> userService.saveUser(request));
    }

    @GetMapping("/{userId}")
    public Mono<User> getBMUser(@PathVariable String userId) {
        return userService.getBMUser(userId);
    }

    @GetMapping
    public Flux<User> getAllBMUsers() {
        return userService.getAllBMUsers();
    }

    @DeleteMapping("/{userId}")
    public Mono<Void> deleteBMUser(@PathVariable String userId) {
        return userService.deleteBMUser(userId);
    }
}
