package com.reactive.mongodb.springfluxflixmono.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Data
@Getter
@Setter
@Document(collection = "category")
public class Category {

    @Id
    private String idcategory;

    @NotBlank
    private String name;

    @NotBlank
    private String description;
}
