package com.reactive.mongodb.springfluxflixmono.service;

import com.reactive.mongodb.springfluxflixmono.entity.Gudang;
import com.reactive.mongodb.springfluxflixmono.model.InsertGudang;
import com.reactive.mongodb.springfluxflixmono.model.UpdateGudang;
import com.reactive.mongodb.springfluxflixmono.repository.GudangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
@Service
public class GudangServiceImpl implements GudangService {

    @Autowired
    private GudangRepository gudangRepository;

    @Override
    public Flux<Gudang> listGudang() {
        return gudangRepository.findAll();
    }

    @Override
    public Mono<Gudang> createdGudang(InsertGudang insertGudang) {
        String idgudang = insertGudang.getIdgudang();
        Gudang gudang = null;
        boolean valid = false;

        if (idgudang == null){
            gudang = new Gudang();
            valid = true;
        }

        gudang.setName(insertGudang.getName());
        gudang.setDescription(insertGudang.getDescription());
        gudang.setCategory(insertGudang.getCategory());
        return gudangRepository.save(gudang);
    }

    @Override
    public Mono<Gudang> updatedGudang(UpdateGudang gudang) {
        return gudangRepository.findById(gudang.getIdgudang())
                .flatMap(currentGudang -> {
                    currentGudang.setIdgudang(gudang.getIdgudang());
                    currentGudang.setName(gudang.getName());
                    currentGudang.setDescription(gudang.getDescription());
                    currentGudang.setCategory(gudang.getCategory());
                    return gudangRepository.save(currentGudang);
                });
    }

    @Override
    public Mono<Void> deletedGudang(String idgudang) {
        return gudangRepository.findById(idgudang)
                .flatMap(currentGudang -> {
                   return gudangRepository.delete(currentGudang);
                });
    }
}
