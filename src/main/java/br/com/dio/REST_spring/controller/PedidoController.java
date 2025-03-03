package br.com.dio.REST_spring.controller;

import br.com.dio.REST_spring.entity.Pedido;
import br.com.dio.REST_spring.entity.Produto;
import br.com.dio.REST_spring.service.PedidoService;
import br.com.dio.REST_spring.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @PostMapping(value = "/save")
    public ResponseEntity<Pedido> salvaProduto(@RequestBody Pedido produto) throws Exception {

        return ResponseEntity.ok().body(service.save(produto));
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Pedido> buscaProduto(@PathVariable Long id){

        return ResponseEntity.ok().body(service.findById(id));
    }
    @GetMapping(value = "/busca-todos")
    public ResponseEntity<List<Pedido>> buscaTodosProdutos(){

        List<Pedido> produtos = service.findAll();

        return ResponseEntity.ok().body(produtos);
    }
}
