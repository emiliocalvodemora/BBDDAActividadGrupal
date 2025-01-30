package com.unir.laboratorio.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateEstacionRequest {

	private String empresa;
	private String direccion;
	private String horario;
	private String fecha_actualizacion;
	private String tipo_venta;
	private String tipo_estacion;
	private String margen;
	private int codigo_postal;
	private double latitud;
	private double longitud;
}
