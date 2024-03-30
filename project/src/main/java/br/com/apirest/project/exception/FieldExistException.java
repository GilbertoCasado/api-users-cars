package br.com.apirest.project.exception;

import br.com.apirest.project.handlers.ErrorMessage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FieldExistException extends Exception {
    private ErrorMessage errorMessage;

    public FieldExistException(ErrorMessage errorMessage) {
        super("exist.field");
        this.errorMessage = errorMessage;
    }
}
