package com.unir.laboratorio.model.db;


import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class EstacionServicio {

    @EmbeddedId
    private EstacionServicioId id; // Clave primaria (latitud y longitud)

    @Column(nullable = false)
    private String empresa; // Clave foránea

    @Column(nullable = false)
    private String direccion; // Clave foránea

    @Column(name = "codigo_postal", nullable = false)
    private Integer codigoPostal; // Clave foránea

    private String horario;

    @Column(name = "margen", columnDefinition = "CHAR")
    private String margen;

    private String tipoEstacion;
    private String tipoVenta;
    private String fechaActualizacion;

    // Getters y Setters
    public EstacionServicioId getId() {
        return id;
    }

    public void setId(EstacionServicioId id) {
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




