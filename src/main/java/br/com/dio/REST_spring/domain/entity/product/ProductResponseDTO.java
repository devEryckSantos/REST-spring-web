package br.com.dio.REST_spring.domain.entity.product;

public record ProductResponseDTO(String id, String name, Double price) {
    public ProductResponseDTO(Product product) {
        this(product.getId(), product.getName(), product.getPrice());
    }
}
