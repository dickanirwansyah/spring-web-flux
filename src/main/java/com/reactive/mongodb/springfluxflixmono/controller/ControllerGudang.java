package com.reactive.mongodb.springfluxflixmono.controller;

import com.reactive.mongodb.springfluxflixmono.entity.Gudang;
import com.reactive.mongodb.springfluxflixmono.model.InsertGudang;
import com.reactive.mongodb.springfluxflixmono.model.UpdateGudang;
import com.reactive.mongodb.springfluxflixmono.service.GudangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/gudang")
public class ControllerGudang {

    @Autowired
    private GudangService gudangService;

    @GetMapping
    public Flux<Gudang> listGudang(){
        return gudangService.listGudang();
    }

    @PostMapping(value = "/created")
    public Mono<ResponseEntity<Gudang>> createdGudang(@RequestBody @Valid InsertGudang gudang){
        return gudangService.createdGudang(gudang)
                .map(callbackJSON -> new ResponseEntity<Gudang>(callbackJSON, HttpStatus.CREATED))
                .defaultIfEmpty(ResponseEntity.badRequest().build());
    }

    @PostMapping(value = "/updated")
    public Mono<ResponseEntity<Gudang>> updatedGudang(@RequestBody @Valid UpdateGudang gudang){
        return gudangService.updatedGudang(gudang)
                .map(callbackJSON -> new ResponseEntity<>(callbackJSON, HttpStatus.OK))
                .defaultIfEmpty(ResponseEntity.badRequest().build());
    }

    @PostMapping(value = "/deleted/{idgudang}")
    public Mono<ResponseEntity<Void>> deleteGudang(@PathVariable String idgudang){
        return gudangService.deletedGudang(idgudang)
                .map(callbackJSON -> new ResponseEntity<Void>(callbackJSON, HttpStatus.OK))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
