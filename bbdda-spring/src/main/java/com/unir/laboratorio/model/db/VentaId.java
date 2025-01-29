package com.unir.laboratorio.model.db;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class VentaId implements Serializable {
    private Double latitud;
    private Double longitud;
    private String tipoCombustible;

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

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    // equals() y hashCode() para que JPA maneje correctamente la clave compuesta
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VentaId that = (VentaId) o;
        return Objects.equals(latitud, that.latitud) &&
                Objects.equals(longitud, that.longitud) &&
                Objects.equals(tipoCombustible, that.tipoCombustible);
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitud, longitud, tipoCombustible);
    }
}

