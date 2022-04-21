package com.rafael.agendaTelefonica.controller.ErrorHandlers;

import java.util.Arrays;
import java.util.List;
import lombok.Getter;

public class APIErrors {
    @Getter
    private List<String> errors;

    public APIErrors(String message){
        this.errors = Arrays.asList(message);
    }
}
