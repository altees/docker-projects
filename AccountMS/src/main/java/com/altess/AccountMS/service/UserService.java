package com.altess.AccountMS.service;

import com.altess.AccountMS.constants.Constants;
import com.altess.AccountMS.entity.User;
import com.altess.AccountMS.repostiories.UserRepository;
import com.altess.AccountMS.request.SignUpByEmailRequest;
import com.altess.AccountMS.response.BaseResponse;
import com.altess.AccountMS.response.ErrorResponse;
import com.altess.AccountMS.response.UserCreatedResponse;
import com.altess.AccountMS.utils.PasswordHasher;
import com.altess.AccountMS.utils.UserHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.time.ZonedDateTime;

@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    // private final RequestValidator requestValidator;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public Mono<ResponseEntity<BaseResponse>> saveUser(SignUpByEmailRequest signUpRequest) {
        //  requestValidator.validateJsonRequest(signUpRequest);
        return userRepository.findByEmail(signUpRequest.getEmail())
                .flatMap(user -> {
                    // User already exists, log the error and return a BadRequest response
                    log.error("User already exists with email: " + signUpRequest.getEmail());
                    BaseResponse errorDetails = new ErrorResponse(Instant.now(), HttpStatus.BAD_REQUEST.value(), "Email", "User already exists");
                    return Mono.just(ResponseEntity.badRequest().body(errorDetails));
                }).switchIfEmpty(Mono.defer(() -> {
                    // Proceed with user creation
                    //  freshAddressValidationForEmail();  we will do later
                    String salt = PasswordHasher.generateSalt();
                    String hashedPassword = PasswordHasher.hashPassword(signUpRequest.getPassword(), salt);
                    signUpRequest.setPassword(hashedPassword);
                    User user = UserHelper.toUser(signUpRequest,salt);
                    return userRepository.save(user)
                            .map(savedUser -> {
                                //sendConfirmationEmail(savedUser); // will do later
                                //pulishKafkaMessage(savedUser); // will do later
                                BaseResponse response = new UserCreatedResponse(savedUser.getUserId(), ZonedDateTime.now().toLocalDateTime().toString(), HttpStatus.CREATED.value(), Constants.SIGN_UP_IS_SUCCESSFUL, "");
                                return ResponseEntity.accepted().body(response);
                            });
                }));

    }

    public Mono<User> findByUsername(String email) {
        return userRepository.findByEmail(email);
    }

    private Mono<? extends ResponseEntity<BaseResponse>> createUser(SignUpByEmailRequest signUpRequest) {
        return null;
    }


    public Mono<User> getBMUser(String userId) {
        return userRepository.findByUserId(userId);
    }

    public Flux<User> getAllBMUsers() {
        return userRepository.findAll();
    }

    public Mono<Void> deleteBMUser(String userId) {
        return userRepository.deleteById(userId);
    }
}
