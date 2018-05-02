package com.reactive.mongodb.springfluxflixmono.service;

import com.reactive.mongodb.springfluxflixmono.entity.Product;
import com.reactive.mongodb.springfluxflixmono.model.InsertProduct;
import com.reactive.mongodb.springfluxflixmono.model.UpdateProduct;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ProductService {

    Flux<Product> listProduct();
    Mono<Product> createdProduct(InsertProduct insertProduct);
    Mono<Product> updatedProduct(UpdateProduct updateProduct);
    Mono<Void> deletedProduct(String idproduct);
    Mono<Product> editedProduct(String idproduct);
}
