package com.spring.moustache.controller.exception;

import java.util.Arrays;
import java.util.List;

public class ApiErrors {

    private List<String> erros;

    public List<String> getErros() {
        return erros;
    }

    public void setErros(List<String> erros) {
        this.erros = erros;
    }

    public ApiErrors(List<String> erros) {
        this.erros = erros;
    }
    public ApiErrors(String message){
        this.erros = Arrays.asList(message);
    }
}
