package br.com.dio.REST_spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String endereco;
    private LocalDate dataPedido;
    private String status;

    @ManyToMany
    @Fetch(FetchMode.SELECT)
    private Set<Produto> produtos;

}
