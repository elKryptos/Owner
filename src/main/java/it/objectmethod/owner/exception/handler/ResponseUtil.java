package it.objectmethod.owner.exception.handler;

import it.objectmethod.owner.dtos.ResponseWrapper;
import it.objectmethod.owner.exception.body.ErrorDetails;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ValidationException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public class ResponseUtil {

    public static <T> ResponseEntity<T> execute(final ResponseHandler<T> handler, final HttpServletRequest request) {
        try {
            return handler.handle();
        } catch (ValidationException e) {
            final ErrorDetails errorDetails = new ErrorDetails(
                    LocalDateTime.now(),
                    e.getMessage(),
                    request.getRequestURI(),
                    HttpStatus.BAD_REQUEST
            );
            ResponseWrapper<T> response = new ResponseWrapper<>("Errore di validazione", (T) errorDetails);
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        } catch (ChangeSetPersister.NotFoundException e) {
            final ErrorDetails errorDetails = new ErrorDetails(
                    LocalDateTime.now(),
                    e.getMessage(),
                    request.getRequestURI(),
                    HttpStatus.NOT_FOUND
            );
            ResponseWrapper<T> response = new ResponseWrapper<>("Elemento non trovato", (T) errorDetails);
            return new ResponseEntity(response, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            final ErrorDetails errorDetails = new ErrorDetails(
                    LocalDateTime.now(),
                    e.getMessage(),
                    request.getRequestURI(),
                    HttpStatus.NOT_FOUND
            );
            ResponseWrapper<T> response = new ResponseWrapper<>("Elemento non trovato", (T) errorDetails);
            return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
