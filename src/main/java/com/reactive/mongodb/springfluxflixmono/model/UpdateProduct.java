package com.reactive.mongodb.springfluxflixmono.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UpdateProduct {

    private String idproduct;
    private String name;
    private String description;
    private int quantity;
    private int unitprice;
}
