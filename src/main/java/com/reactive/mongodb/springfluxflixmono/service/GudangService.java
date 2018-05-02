package com.reactive.mongodb.springfluxflixmono.service;

import com.reactive.mongodb.springfluxflixmono.entity.Gudang;
import com.reactive.mongodb.springfluxflixmono.model.InsertGudang;
import com.reactive.mongodb.springfluxflixmono.model.UpdateGudang;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface GudangService {

    Flux<Gudang> listGudang();
    Mono<Gudang> createdGudang(InsertGudang gudang);
    Mono<Gudang> updatedGudang(UpdateGudang gudang);
    Mono<Void> deletedGudang(String idgudang);
}
