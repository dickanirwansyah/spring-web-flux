package com.reactive.mongodb.springfluxflixmono.service;

import com.reactive.mongodb.springfluxflixmono.entity.Product;
import com.reactive.mongodb.springfluxflixmono.model.InsertProduct;
import com.reactive.mongodb.springfluxflixmono.model.UpdateProduct;
import com.reactive.mongodb.springfluxflixmono.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
@Repository
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Flux<Product> listProduct() {
       return productRepository.findAll();
    }

    @Override
    public Mono<Product> createdProduct(InsertProduct insertProduct) {

        String idproduct = insertProduct.getIdproduct();
        Product product = null;
        boolean valid = false;

        if(idproduct == null){
            product = new Product();
            valid = true;
        }
        product.setName(insertProduct.getName());
        product.setDescription(insertProduct.getDescription());
        product.setQuantity(insertProduct.getQuantity());
        product.setUnitprice(insertProduct.getUnitprice());
        return productRepository.save(product);
    }

    @Override
    public Mono<Product> updatedProduct(UpdateProduct updateProduct) {
        return productRepository.findById(updateProduct.getIdproduct())
                .flatMap(currentProduct -> {
                    currentProduct.setIdproduct(updateProduct.getIdproduct());
                    currentProduct.setName(updateProduct.getName());
                    currentProduct.setDescription(updateProduct.getDescription());
                    currentProduct.setQuantity(updateProduct.getQuantity());
                    currentProduct.setUnitprice(updateProduct.getUnitprice());
                    return productRepository.save(currentProduct);
                });
    }

    @Override
    public Mono<Void> deletedProduct(String idproduct) {
        return productRepository.findById(idproduct)
                .flatMap(destroyProduct -> {
                    return productRepository.delete(destroyProduct);
                });
    }

    @Override
    public Mono<Product> editedProduct(String idproduct) {
        return null;
    }
}
