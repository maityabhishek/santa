package com.santainc;

import com.fasterxml.jackson.annotation.JacksonInject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.support.RequestContext;

@RestControllerAdvice
@Slf4j
public class AllExceptionHandler {

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<Object> handelAllException(Throwable e){

        return new ResponseEntity<>("Some Internal Error Has Occured", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
