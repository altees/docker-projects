package com.altess.AccountMS.controller;

import com.altess.AccountMS.entity.AuthUser;
import com.altess.AccountMS.request.AuthRequest;
import com.altess.AccountMS.response.AuthResponse;
import com.altess.AccountMS.service.UserService;
import com.altess.AccountMS.utils.JWTUtil;
import com.altess.AccountMS.utils.PBKDF2Encoder;
import com.altess.AccountMS.utils.PasswordHasher;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Arrays;

@AllArgsConstructor
@RestController
public class AuthenticationREST {

    private JWTUtil jwtUtil;
    private PBKDF2Encoder passwordEncoder;
    private UserService userService;


    @GetMapping("/test")
    public Mono<ResponseEntity<String>> test() {
        return Mono.just(ResponseEntity.ok("test"));
    }

    @PostMapping("/login")
    public Mono<ResponseEntity<AuthResponse>> login(@RequestBody AuthRequest ar) {
        return userService.findByUsername(ar.getUsername())
                .filter(userDetails -> PasswordHasher.verifyPassword(ar.getPassword(), userDetails.getSalt(), userDetails.getPassword()))
                .map(userDetails -> {
                    AuthUser authUser = new AuthUser();
                    authUser.setUsername(userDetails.getEmail());
                    authUser.setPassword(userDetails.getPassword());
                    authUser.setEnabled(userDetails.isActive());
                    authUser.setRoles(Arrays.asList(userDetails.getAccountType()));
                    return ResponseEntity.ok(new AuthResponse(jwtUtil.generateToken(authUser), "SUCCESS", null));
                }).switchIfEmpty(Mono.just(ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(new AuthResponse(null, "FAILED", "Invalid username or password"))));
    }

}