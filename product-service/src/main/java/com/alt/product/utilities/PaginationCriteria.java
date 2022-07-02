package com.alt.product.utilities;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

@Setter
@Getter
public class PaginationCriteria {



    static {
        Optional<Integer> integer = Optional.of(new Integer(0));
        integer.orElseThrow(()-> new NullPointerException("test"));
        Integer integer1 = integer.orElse(6);
        System.out.println(integer1);
    }





    private int pageSize;
    private int pageNumber;
}
