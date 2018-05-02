package com.reactive.mongodb.springfluxflixmono.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Getter
@Setter
public class InsertProduct {

    private String idproduct;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotNull
    private int quantity;

    @NotNull
    private int unitprice;
}
