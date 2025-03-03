package br.com.dio.REST_spring.controller;

import br.com.dio.REST_spring.entity.Produto;
import br.com.dio.REST_spring.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @PostMapping(value = "/save")
    public ResponseEntity<Produto> salvaProduto(@RequestBody Produto produto) throws Exception {

        return ResponseEntity.ok().body(service.save(produto));
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Produto> buscaProduto(@PathVariable Long id){

        return ResponseEntity.ok().body(service.findById(id));
    }
    @GetMapping(value = "/busca-todos")
    public ResponseEntity<List<Produto>> buscaTodosProdutos(){

        List<Produto> produtos = service.findAll();

        return ResponseEntity.ok().body(produtos);
    }
}
