package com.unir.laboratorio.model.db;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

@Document(indexName = "estacion_servicio")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class EstacionServicioElasticsearch {

    @Id
    private String id; // Clave primaria (latitud + longitud)

    @MultiField(mainField = @Field(type = FieldType.Keyword, name = "name"),
            otherFields = @InnerField(suffix = "search", type = FieldType.Search_As_You_Type))
    private String empresa;

    @MultiField(mainField = @Field(type = FieldType.Keyword, name = "name"),
            otherFields = @InnerField(suffix = "search", type = FieldType.Search_As_You_Type))
    private String direccion;

    @Field(type = FieldType.Search_As_You_Type, name = "description")
    private Integer codigoPostal;

    @Field(type = FieldType.Text, name = "country")
    private String horario;

    @Field(type = FieldType.Text, name = "country")
    private String margen;

    @Field(type = FieldType.Text, name = "country")
    private String tipoEstacion;

    @Field(type = FieldType.Text, name = "country")
    private String tipoVenta;

    @Field(type = FieldType.Text, name = "country")
    private String fechaActualizacion;

}

