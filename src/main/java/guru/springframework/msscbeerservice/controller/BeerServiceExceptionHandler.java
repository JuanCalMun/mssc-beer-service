package guru.springframework.msscbeerservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class BeerServiceExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> validationErrorHandler(MethodArgumentNotValidException ex) {
        List<String> errorsList = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(e -> e.getObjectName() + ": " + e.getField() + " -> " + e.getDefaultMessage())
                .collect(Collectors.toList());
        return new ResponseEntity(errorsList, HttpStatus.BAD_REQUEST);
    }
}
