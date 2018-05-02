package com.reactive.mongodb.springfluxflixmono.repository;

import com.reactive.mongodb.springfluxflixmono.entity.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductRepository extends ReactiveMongoRepository<Product, String>{
}
