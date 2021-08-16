package com.alt.product.entities;

import com.alt.product.enums.ProductCategory;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "product")
public class Product extends BaseEntity{

    private String productName;
    private String productDiscription;
    private ProductCategory productCategory;
    private List<String> productImagesOrVideosUrl=new ArrayList<>(4);
    private boolean productStatus;
    private double  productPrice;
    private int productDiscountPercantage;


    private int portNo;  //for loadbalancer testing

}
