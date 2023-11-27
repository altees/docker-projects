
package com.altess.AccountMS.utils;

import com.altess.AccountMS.request.BaseRequest;
import io.vavr.control.Option;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

@Component

public class RequestValidator {


    public RequestValidator() {
        this.validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    Validator validator;


    public void validateJsonRequest(BaseRequest request) {
        //Handling annotation based data validation here
        Set<ConstraintViolation<BaseRequest>> violations = validator.validate(request);
        // if violations size > 0, It means, BaseRequest has some error
        Option.of(violations)
                .filter(violationSet -> violationSet.size() <= 0)
                .getOrElse(() -> {
//                    throw new InvalidParameter(errMsg,violations.stream().map(x -> (x.getPropertyPath() +
//                            ":" + x.getMessage())).toArray(String[]::new));
                    throw new ConstraintViolationException(violations);
                });
    }

    /*public void validateRequest(BaseRequest request) {
        Errors errors = new BeanPropertyBindingResult(request, "request");
        validator.validate(request, errors);

        if (errors.hasErrors()) {
            // Handle validation errors
            Option.of(errors.getFieldErrors())
                    .filter(fieldErrors -> fieldErrors.size()<=0)
                    .getOrElse(()->{
                        throw new ConstraintViolationException(errors.getFieldErrors());
                    });
            // You can throw an exception or handle errors as needed
        } else {
            // Proceed with valid object
            System.out.println("Request is valid");
        }
    }*/
}

