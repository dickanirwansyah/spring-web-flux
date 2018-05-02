package com.reactive.mongodb.springfluxflixmono.model;

import com.reactive.mongodb.springfluxflixmono.entity.Category;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Getter
@Setter
public class UpdateGudang {

    @NotBlank
    private String idgudang;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotNull
    private Category category;
}
