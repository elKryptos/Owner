//package it.objectmethod.owner.exception;
//
//import it.objectmethod.owner.exception.body.ErrorDetails;
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//import java.time.LocalDateTime;
//
//@ControllerAdvice
//public class GlobalExceptionHandler {
//
//    @ExceptionHandler(ValidationException.class)
//    public ResponseEntity<ErrorDetails> handleValidationException(ValidationException e, HttpServletRequest request) {
//        return createErrorResponse(
//                e.getMessage(),
//                request,
//                HttpStatus.BAD_REQUEST,
//                "Errore di validazione");
//    }
//
//    @ExceptionHandler(NotFoundException.class)
//    public ResponseEntity<ErrorDetails> handleNotFoundException(NotFoundException e, HttpServletRequest request) {
//        return createErrorResponse(
//                e.getMessage(),
//                request,
//                HttpStatus.NOT_FOUND,
//                "Elemento non trovato");
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorDetails> handleGenericException(Exception e, HttpServletRequest request) {
//        return createErrorResponse(
//                "Errore interno del server",
//                request,
//                HttpStatus.INTERNAL_SERVER_ERROR,
//                "Errore interno");
//    }
//
//    private ResponseEntity<ErrorDetails> createErrorResponse(String message, HttpServletRequest request, HttpStatus status, String userMessage) {
//        ErrorDetails errorDetails = new ErrorDetails(
//                LocalDateTime.now(),
//                message,
//                request.getRequestURI(),
//                status
//        );
//        return new ResponseEntity<>(errorDetails, status);
//    }
//}
