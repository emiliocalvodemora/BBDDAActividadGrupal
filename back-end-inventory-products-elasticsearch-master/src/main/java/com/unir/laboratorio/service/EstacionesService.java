package com.unir.laboratorio.service;

import com.unir.laboratorio.model.db.EstacionServicio;
import com.unir.laboratorio.model.request.CreateEstacionRequest;
import com.unir.laboratorio.model.response.EstacionesServicioQueryResponse;


public interface EstacionesService {

	EstacionesServicioQueryResponse getEstacionesServicio(double latitud, double longitud, String empresa, String direccion, int codigoPostal, String horario, String margen, String tipoEstacion, String tipoVenta, String fechaActualizacion);

	EstacionServicio getEstacionServicio(String estacionId);
	
	Boolean removeEstacionServicio(String estacionId);

	EstacionServicio createEstacionServicio(CreateEstacionRequest request);

}
