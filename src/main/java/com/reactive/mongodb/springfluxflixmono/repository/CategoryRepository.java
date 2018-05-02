package com.reactive.mongodb.springfluxflixmono.repository;

import com.reactive.mongodb.springfluxflixmono.entity.Category;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CategoryRepository extends ReactiveMongoRepository<Category, String>{
}
