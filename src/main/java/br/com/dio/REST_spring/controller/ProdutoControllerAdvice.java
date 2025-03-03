package br.com.dio.REST_spring.controller;

import br.com.dio.REST_spring.exception.ProductNullException;
import br.com.dio.REST_spring.exception.ProductPriceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.*;

@ControllerAdvice
public class ProdutoControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> erro(){

        Map<String, Object> body = new HashMap<String, Object>();

        body.put("message", "Ocorreu um erro ao cadastrar o produto.");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
    @ExceptionHandler(ProductNullException.class)
    public ResponseEntity<Object> capturaErroNull(){

        Map<String, Object> body = new HashMap<String, Object>();

        body.put("message", "Verifique se os campos do produto estão preenchidos corretamente.");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
    @ExceptionHandler(ProductPriceException.class)
    public ResponseEntity<Object> capturaErroPreco(){

        Map<String, Object> body = new HashMap<String, Object>();

        body.put("message", "O preço do produto não pode ser menor que 0.");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
}
