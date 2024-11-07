package com.kethlyn.crud.controllers;


import com.kethlyn.crud.domain.product.Product;
import com.kethlyn.crud.domain.product.ProductRepository;
import com.kethlyn.crud.domain.product.RequestProduct;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public ResponseEntity getAllProduct(){
        var allProducts = productRepository.findAll();
        return ResponseEntity.ok(allProducts);
    }

    @PostMapping
    public ResponseEntity addProduct(@RequestBody @Valid RequestProduct data){
        Product product = new Product(data);
        productRepository.save(product);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@PathVariable String id, @RequestBody @Valid RequestProduct data){
        Optional<Product> optionalProduct = productRepository.findById(id);

        if(optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            product.setPrice(data.price());
            product.setName(data.name());

            // Persistir as alterações no banco de dados
            product = productRepository.save(product);
            return ResponseEntity.ok(product);
        } else {
            // Produto não encontrado, tratar o caso de erro
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable String id, @RequestBody @Valid RequestProduct data){
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            productRepository.delete(product.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
