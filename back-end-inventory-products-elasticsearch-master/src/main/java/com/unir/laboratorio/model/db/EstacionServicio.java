package com.unir.laboratorio.model.db;


import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
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

}




