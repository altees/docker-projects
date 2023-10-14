/*
package com.altess.AccountMS.utils;

import com.altess.AccountMS.request.BaseRequest;
import io.vavr.control.Option;
import org.springframework.stereotype.Component;

import javax.validation.*;
import java.util.Set;

@Component
public class RequestValidator {

    private static final Validator validator;

    static {
        Configuration<?> config = Validation.byDefaultProvider().configure();
        ValidatorFactory factory = config.buildValidatorFactory();
        validator = factory.getValidator();
        factory.close();
    }


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
}
*/
