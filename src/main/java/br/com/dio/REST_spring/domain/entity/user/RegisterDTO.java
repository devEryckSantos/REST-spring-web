package br.com.dio.REST_spring.domain.entity.user;

public record RegisterDTO(String login, String password, UserRole role) {
}
