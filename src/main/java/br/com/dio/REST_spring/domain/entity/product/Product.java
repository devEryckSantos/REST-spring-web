package br.com.dio.REST_spring.domain.entity.product;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "product")
@Entity(name = "product")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private Double price;


    public Product(ProductRequestDTO data) {
        this.price = data.price();
        this.name = data.name();
    }
}