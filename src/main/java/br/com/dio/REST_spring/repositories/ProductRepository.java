package br.com.dio.REST_spring.repositories;

import br.com.dio.REST_spring.domain.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {

}
