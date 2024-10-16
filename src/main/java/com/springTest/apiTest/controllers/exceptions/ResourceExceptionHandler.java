package com.springTest.apiTest.controllers.exceptions;

import com.springTest.apiTest.services.exceptions.DatabaseException;
import com.springTest.apiTest.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler extends RuntimeException {
  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){

    StandardError err = new StandardError(
            Instant.now(), HttpStatus.NOT_FOUND.value(), "Resource not found", e.getMessage(), request.getRequestURI()
    );

    return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(DatabaseException.class)
  public ResponseEntity<StandardError> databaseNotFound(DatabaseException e, HttpServletRequest request){

    StandardError err = new StandardError(
            Instant.now(), HttpStatus.BAD_REQUEST.value(), "Resource not found", e.getMessage(), request.getRequestURI()
    );

    return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
  }

}