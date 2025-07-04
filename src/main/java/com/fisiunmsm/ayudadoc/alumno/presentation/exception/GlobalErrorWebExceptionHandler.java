package com.fisiunmsm.ayudadoc.alumno.presentation.exception;

import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fisiunmsm.ayudadoc.alumno.presentation.dto.ErrorResponse;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

@Configuration
@Order(-2)
public class GlobalErrorWebExceptionHandler implements ErrorWebExceptionHandler {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
        
        ErrorResponse errorResponse = createErrorResponse(ex);
        HttpStatus status = determineHttpStatus(ex);
        
        exchange.getResponse().setStatusCode(status);
        exchange.getResponse().getHeaders().add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        
        try {
            String jsonResponse = objectMapper.writeValueAsString(errorResponse);
            DataBuffer buffer = exchange.getResponse().bufferFactory()
                    .wrap(jsonResponse.getBytes(StandardCharsets.UTF_8));
            
            return exchange.getResponse().writeWith(Mono.just(buffer));
        } catch (Exception e) {
            return exchange.getResponse().setComplete();
        }
    }

    private ErrorResponse createErrorResponse(Throwable ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setStatus(determineHttpStatus(ex).value());
        errorResponse.setError(determineHttpStatus(ex).getReasonPhrase());
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setPath(getCurrentPath());
        
        return errorResponse;
    }

    private HttpStatus determineHttpStatus(Throwable ex) {
        if (ex instanceof IllegalArgumentException) {
            return HttpStatus.BAD_REQUEST;
        } else if (ex instanceof RuntimeException) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        } else if (ex.getMessage() != null && ex.getMessage().contains("not found")) {
            return HttpStatus.NOT_FOUND;
        } else if (ex.getMessage() != null && ex.getMessage().contains("unauthorized")) {
            return HttpStatus.UNAUTHORIZED;
        } else if (ex.getMessage() != null && ex.getMessage().contains("forbidden")) {
            return HttpStatus.FORBIDDEN;
        }
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

    private String getCurrentPath() {
        // En un handler global, es difícil obtener el path exacto
        // Se puede mejorar pasando información adicional
        return "/api-alumno/v1";
    }
}