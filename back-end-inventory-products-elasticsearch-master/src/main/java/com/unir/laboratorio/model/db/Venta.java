package com.unir.laboratorio.model.db;


import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Venta {

    @EmbeddedId
    private VentaId id; // Clave primaria compuesta

    private Double precio;

    @Column(name = "rem", columnDefinition = "CHAR")
    private String rem;

    // Getters y Setters
    public VentaId getId() {
        return id;
    }

    public void setId(VentaId id) {
        this.id = id;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getRem() {
        return rem;
    }

    public void setRem(String rem) {
        this.rem = rem;
    }
}
