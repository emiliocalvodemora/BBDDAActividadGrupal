package com.unir.laboratorio.model.db;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Combustible {

    @Id
    private String tipoCombustible; // Clave primaria

    // Getters y Setters
    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }
}
