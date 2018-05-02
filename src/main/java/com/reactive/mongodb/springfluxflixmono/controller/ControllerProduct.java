package com.reactive.mongodb.springfluxflixmono.controller;

import com.reactive.mongodb.springfluxflixmono.entity.Product;
import com.reactive.mongodb.springfluxflixmono.model.InsertProduct;
import com.reactive.mongodb.springfluxflixmono.model.UpdateProduct;
import com.reactive.mongodb.springfluxflixmono.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/product")
public class ControllerProduct {

    @Autowired
    private ProductService productService;

    @GetMapping
    public Flux<ResponseEntity<Product>> listProduct(){
        return productService.listProduct()
                .map(callbackJSON -> new ResponseEntity<Product>(callbackJSON, HttpStatus.OK))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping(value = "/created")
    public Mono<ResponseEntity<Product>> createdProduct(@RequestBody @Valid InsertProduct product){
       return productService.createdProduct(product)
               .map(callbackJSON -> new ResponseEntity<Product>(callbackJSON, HttpStatus.CREATED))
               .defaultIfEmpty(ResponseEntity.badRequest().build());
    }

    @PostMapping(value = "/updated")
    public Mono<ResponseEntity<Product>> updatedProduct(@RequestBody @Valid UpdateProduct product){
        return productService.updatedProduct(product)
                .map(callbackJSON -> new ResponseEntity<Product>(callbackJSON, HttpStatus.OK))
                .defaultIfEmpty(ResponseEntity.badRequest().build());
    }

    @PostMapping(value = "/deleted/{idproduct}")
    public Mono<Void> deletedProduct(@PathVariable String idproduct){
        return productService.deletedProduct(idproduct);
    }
}
