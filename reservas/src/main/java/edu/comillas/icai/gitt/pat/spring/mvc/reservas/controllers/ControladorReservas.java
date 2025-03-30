package edu.comillas.icai.gitt.pat.spring.mvc.reservas.controllers;

import edu.comillas.icai.gitt.pat.spring.mvc.reservas.exceptions.ExcepcionReservaIncorrecta;
import edu.comillas.icai.gitt.pat.spring.mvc.reservas.models.ModeloCampoIncorrecto;
import edu.comillas.icai.gitt.pat.spring.mvc.reservas.models.ModeloReserva;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
public class ControladorReservas {

    private final Map<Integer, ModeloReserva> reservas = new HashMap<>();
    private int idActual = 1;

    @PostMapping("/api/reservas")
    @ResponseStatus(HttpStatus.CREATED)
    public ModeloReserva crear(@Valid @RequestBody ModeloReserva nueva, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ExcepcionReservaIncorrecta(bindingResult);
        }
        nueva.setId(idActual++);
        reservas.put(nueva.getId(), nueva);
        return nueva;
    }

    @GetMapping("/api/reservas/{id}")
    public ModeloReserva obtener(@PathVariable int id) {
        ModeloReserva r = reservas.get(id);
        if (r == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reserva no encontrada");
        }
        return r;
    }

    @PutMapping("/api/reservas/{id}")
    public ModeloReserva actualizar(@PathVariable int id, @Valid @RequestBody ModeloReserva nueva, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ExcepcionReservaIncorrecta(bindingResult);
        }
        if (!reservas.containsKey(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reserva no encontrada");
        }
        nueva.setId(id);
        reservas.put(id, nueva);
        return nueva;
    }

    @DeleteMapping("/api/reservas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrar(@PathVariable int id) {
        reservas.remove(id);
    }

    @ExceptionHandler(ExcepcionReservaIncorrecta.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<ModeloCampoIncorrecto> errores(ExcepcionReservaIncorrecta ex) {
        return ex.getErrores().getFieldErrors().stream().map(error ->
                new ModeloCampoIncorrecto(
                        error.getDefaultMessage(),
                        error.getField(),
                        error.getRejectedValue()
                )
        ).toList();
    }
}
