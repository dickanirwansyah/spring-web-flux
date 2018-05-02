package com.reactive.mongodb.springfluxflixmono.repository;

import com.reactive.mongodb.springfluxflixmono.entity.Gudang;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface GudangRepository extends ReactiveMongoRepository<Gudang, String>{
}
