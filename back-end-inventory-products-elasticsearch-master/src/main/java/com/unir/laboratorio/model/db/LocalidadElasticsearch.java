package com.unir.laboratorio.model.db;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "localidad")
public class LocalidadElasticsearch {

    @Id
    private Integer idLocalidad; // Clave primaria en ElasticSearch

    private Integer idMunicipio;
    private String nombreLocalidad;

    // Getters y Setters
    public Integer getIdLocalidad() {
        return idLocalidad;
    }

    public void setIdLocalidad(Integer idLocalidad) {
        this.idLocalidad = idLocalidad;
    }

    public Integer getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Integer idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getNombreLocalidad() {
        return nombreLocalidad;
    }

    public void setNombreLocalidad(String nombreLocalidad) {
        this.nombreLocalidad = nombreLocalidad;
    }
}
