package com.unir.laboratorio.service;

import com.unir.laboratorio.model.db.Estacion;
import com.unir.laboratorio.model.request.CreateEstacionRequest;
import com.unir.laboratorio.model.response.EstacionesQueryResponse;


public interface EstacionesService {

	EstacionesQueryResponse getEstaciones(String name, String description, String country, Boolean aggregate);

	Estacion getEstacion(String estacionId);
	
	Boolean removeEstacion(String estacionId);

	Estacion createEstacion(CreateEstacionRequest request);

}
