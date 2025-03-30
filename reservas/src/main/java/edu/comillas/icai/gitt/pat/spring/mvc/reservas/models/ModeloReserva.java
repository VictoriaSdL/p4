package edu.comillas.icai.gitt.pat.spring.mvc.reservas.models;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class ModeloReserva {

    private int id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotNull(message = "La fecha es obligatoria")
    private LocalDate fecha;

    @Min(value = 1, message = "La pista debe ser al menos la número 1")
    @Max(value = 10, message = "Solo hay 10 pistas disponibles")
    private int pista;

    public ModeloReserva() {
    }

    public ModeloReserva(int id, String nombre, LocalDate fecha, int pista) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.pista = pista;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public int getPista() { return pista; }
    public void setPista(int pista) { this.pista = pista; }
}
