package edu.comillas.icai.gitt.pat.spring.mvc.reservas.exceptions;

import org.springframework.validation.BindingResult;

public class ExcepcionReservaIncorrecta extends RuntimeException {
    private final BindingResult errores;

    public ExcepcionReservaIncorrecta(BindingResult errores) {
        this.errores = errores;
    }

    public BindingResult getErrores() {
        return errores;
    }
}
