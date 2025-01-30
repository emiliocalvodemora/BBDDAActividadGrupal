package com.unir.laboratorio.model.db;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Provincia {

    @Id
    private String nombre; // Clave primaria

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
