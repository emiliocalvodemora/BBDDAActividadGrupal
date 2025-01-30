package com.unir.laboratorio.controller;

import com.unir.laboratorio.model.db.Estacion;
import com.unir.laboratorio.model.request.CreateEstacionRequest;
import com.unir.laboratorio.model.response.EstacionesQueryResponse;
import com.unir.laboratorio.service.EstacionesService;
import com.unir.laboratorio.service.EstacionesServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
public class EstacionesController {

	private final EstacionesService service;
	private final EstacionesServiceImpl estacionesServiceImpl;

	@GetMapping("/estaciones")
	public ResponseEntity<EstacionesQueryResponse> getEstaciones(
			@RequestHeader Map<String, String> headers,
			@RequestParam(required = false) String description, 
			@RequestParam(required = false) String name, 
			@RequestParam(required = false) String country,
			@RequestParam(required = false, defaultValue = "false") Boolean aggregate) {

		log.info("headers: {}", headers);
		EstacionesQueryResponse estaciones = service.getEstaciones(name, description, country, aggregate);
		return ResponseEntity.ok(estaciones);
	}

	@GetMapping("/estaciones/{estacionId}")
	public ResponseEntity<Estacion> getEstacion(@PathVariable String estacionId) {

		log.info("Request received for estacion {}", estacionId);
		Estacion estacion = service.getEstacion(estacionId);

		if (estacion != null) {
			return ResponseEntity.ok(estacion);
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@DeleteMapping("/estaciones/{estacionId}")
	public ResponseEntity<Void> deleteEstacion(@PathVariable String estacionId) {

		Boolean removed = service.removeEstacion(estacionId);

		if (Boolean.TRUE.equals(removed)) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@PostMapping("/estaciones")
	public ResponseEntity<Estacion> getEstacion(@RequestBody CreateEstacionRequest request) {

		Estacion createdEstacion = service.createEstacion(request);

		if (createdEstacion != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(createdEstacion);
		} else {
			return ResponseEntity.badRequest().build();
		}

	}
//	@GetMapping("/run")
//	public ResponseEntity<String> ejecutarETL() {
//		estacionesServiceImpl.ejecutarETL();
//		return ResponseEntity.ok("ETL ejecutada correctamente para la tabla 'estacion_servicio'.");
//	}

}
