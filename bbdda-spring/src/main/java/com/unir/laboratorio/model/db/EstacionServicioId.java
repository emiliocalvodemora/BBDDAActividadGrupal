package com.unir.laboratorio.model.db;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EstacionServicioId implements Serializable {
    private Double latitud;
    private Double longitud;

    // Getters y Setters
    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    // equals() y hashCode() para que JPA gestione correctamente la clave compuesta
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstacionServicioId that = (EstacionServicioId) o;
        return Objects.equals(latitud, that.latitud) && Objects.equals(longitud, that.longitud);
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitud, longitud);
    }
}

