package it.objectmethod.owner.exception.handler;

import org.springframework.http.ResponseEntity;

@FunctionalInterface
public interface ResponseHandler<T> {
    ResponseEntity<T> handle() throws Exception;
}
