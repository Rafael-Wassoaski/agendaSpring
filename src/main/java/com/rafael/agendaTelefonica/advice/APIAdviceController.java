package com.rafael.agendaTelefonica.advice;

import com.rafael.agendaTelefonica.controller.ErrorHandlers.APIErrors;
import com.rafael.agendaTelefonica.exceptions.UnprocessableEntityException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class APIAdviceController {

    @ExceptionHandler(UnprocessableEntityException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public APIErrors unprocessableEntityException(String message){
        return new APIErrors(message);
    }
    
}
