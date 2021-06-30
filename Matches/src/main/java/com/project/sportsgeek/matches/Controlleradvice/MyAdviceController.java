package com.project.sportsgeek.matches.Controlleradvice;

import com.project.sportsgeek.matches.model.CustomHttpErrorResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class MyAdviceController {

    @Value("${notFoundError}")
    Integer notFoundError;

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleResourceNotFound(RuntimeException ex, WebRequest wr) {
        CustomHttpErrorResponse cr = new CustomHttpErrorResponse(new Date(), notFoundError, ex.getMessage(), wr.getDescription(false));
        return new ResponseEntity(cr, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception ex, WebRequest wr) {
        CustomHttpErrorResponse cr = new CustomHttpErrorResponse(new Date(), notFoundError, ex.getMessage(), wr.getDescription(false));
        return new ResponseEntity(cr, HttpStatus.BAD_REQUEST);
    }
}
