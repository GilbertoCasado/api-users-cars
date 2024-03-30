package br.com.apirest.project.handlers;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorMessage {
    private int erroCode;
    private String message;

    public ErrorMessage(int erroCode, String message) {
    	this.erroCode = erroCode;
    	this.message = message;
        
    }
}
