package com.altess.AccountMS.repostiories;

import com.altess.AccountMS.entity.User;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<User, String> {

    @Query("SELECT * FROM account WHERE email = :email")
    Mono<User> findByEmail(String email);
}
