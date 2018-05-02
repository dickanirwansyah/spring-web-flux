package com.reactive.mongodb.springfluxflixmono.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Getter
@Setter
@Document(collection = "gudang")
public class Gudang {

    @Id
    private String idgudang;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotNull
    private Category category;
}
