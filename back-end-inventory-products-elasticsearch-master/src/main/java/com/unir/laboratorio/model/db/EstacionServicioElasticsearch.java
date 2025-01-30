package com.unir.laboratorio.model.db;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "estacion_servicio")
public class EstacionServicioElasticsearch {

    @Id
    private String id; // Clave primaria (latitud + longitud)

    private String empresa;
    private String direccion;
    private Integer codigoPostal;
    private String horario;
    private String margen;
    private String tipoEstacion;
    private String tipoVenta;
    private String fechaActualizacion;

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(Integer codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getMargen() {
        return margen;
    }

    public void setMargen(String margen) {
        this.margen = margen;
    }

    public String getTipoEstacion() {
        return tipoEstacion;
    }

    public void setTipoEstacion(String tipoEstacion) {
        this.tipoEstacion = tipoEstacion;
    }

    public String getTipoVenta() {
        return tipoVenta;
    }

    public void setTipoVenta(String tipoVenta) {
        this.tipoVenta = tipoVenta;
    }

    public String getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(String fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
}

