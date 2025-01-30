package com.unir.laboratorio.model.db;


import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class Direccion {

    @EmbeddedId
    private DireccionId id; // Clave primaria compuesta

    @Column(name = "id_localidad")
    private Integer idLocalidad; // Clave foránea

    // Getters y Setters
    public DireccionId getId() {
        return id;
    }

    public void setId(DireccionId id) {
        this.id = id;
    }

    public Integer getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(Integer idLocalidad) {
        this.idLocalidad = idLocalidad;
    }
}


