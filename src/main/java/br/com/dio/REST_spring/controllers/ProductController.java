package br.com.dio.REST_spring.controllers;

import br.com.dio.REST_spring.domain.entity.product.Product;
import br.com.dio.REST_spring.domain.entity.product.ProductRequestDTO;
import br.com.dio.REST_spring.domain.entity.product.ProductResponseDTO;
import br.com.dio.REST_spring.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductRepository repository;

    @PostMapping
    public ResponseEntity postProduct(@RequestBody ProductRequestDTO body) {
        Product newProduct = new Product(body);

        this.repository.save(newProduct);
        return ResponseEntity.ok().body(newProduct);
    }
    @GetMapping
    public ResponseEntity fetAllProducts(){
        List<ProductResponseDTO> productList = this.repository.findAll().stream().map(ProductResponseDTO::new).toList();

        return ResponseEntity.ok(productList);
    }
}
