package com.project.sportsgeek.matches.controller;

import com.project.sportsgeek.matches.model.CustomHttpErrorResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestController
public class CustomErrorController implements ErrorController {

    @Value("${invalidPath}")
    String path;

    @Value("${notFoundError}")
    Integer notFoundError;

    @RequestMapping(value = "/error", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> error(WebRequest wr) {
        CustomHttpErrorResponse cr = new CustomHttpErrorResponse(new Date(), notFoundError,String.format(path),wr.getDescription(false));
        return new ResponseEntity(cr, HttpStatus.BAD_REQUEST);
    }

}
