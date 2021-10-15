package com.prueba.veterinaria.config.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response {

    private String response;
    private String message;
    private String status;

    public Response(String response, String message, String status) {
        this.response = response;
        this.message = message;
        this.status = status;
    }
}
