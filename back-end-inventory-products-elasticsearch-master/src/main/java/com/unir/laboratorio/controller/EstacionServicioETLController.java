package com.unir.laboratorio.controller;

import com.unir.laboratorio.model.db.EstacionServicio;
import com.unir.laboratorio.service.EstacionServicioETLService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.unir.laboratorio.model.db.Estacion;
import com.unir.laboratorio.model.request.CreateEstacionRequest;
import com.unir.laboratorio.model.response.EstacionesServicioQueryResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/etl/estacion-servicio")
@RequiredArgsConstructor
@Slf4j
public class EstacionServicioETLController {

    private final EstacionServicioETLService estacionServicioETLService;

    @GetMapping("/run")
    public ResponseEntity<String> ejecutarETL() {
        estacionServicioETLService.ejecutarETL();
        return ResponseEntity.ok("ETL ejecutada correctamente para la tabla 'estacion_servicio'.");
    }

    @GetMapping("/estaciones")
    public ResponseEntity<EstacionesServicioQueryResponse> getEstaciones(
            @RequestHeader Map<String, String> headers,
            @RequestParam(required = false) double latitud,
            @RequestParam(required = false) double longitud,
            @RequestParam(required = false) String empresa,
            @RequestParam(required = false) String direccion,
            @RequestParam(required = false) int codigoPostal,
            @RequestParam(required = false) String horario,
            @RequestParam(required = false) String margen,
            @RequestParam(required = false) String tipoEstacion,
            @RequestParam(required = false) String tipoVenta,
            @RequestParam(required = false) String fechaActualizacion) {

        log.info("headers: {}", headers);
        EstacionesServicioQueryResponse estaciones = estacionServicioETLService.getEstaciones(latitud, longitud, empresa, direccion, codigoPostal, horario, margen, tipoEstacion, tipoVenta, fechaActualizacion);
        return ResponseEntity.ok(estaciones);
    }

//    @GetMapping("/estaciones/{estacionId}")
//    public ResponseEntity<EstacionServicio> getEstacion(@PathVariable String estacionId) {
//
//        log.info("Request received for estacion {}", estacionId);
//        EstacionServicio estacionServicio = estacionServicioETLService.getEstacionServicio(estacionId);
//
//        if (estacionServicio != null) {
//            return ResponseEntity.ok(estacionServicio);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//
//    }

    @DeleteMapping("/estaciones/{estacionId}")
    public ResponseEntity<Void> deleteEstacion(@PathVariable String estacionId) {

        Boolean removed = estacionServicioETLService.removeEstacion(estacionId);

        if (Boolean.TRUE.equals(removed)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/estaciones")
    public ResponseEntity<Estacion> getEstacion(@RequestBody CreateEstacionRequest request) {

        Estacion createdEstacion = estacionServicioETLService.createEstacion(request);

        if (createdEstacion != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdEstacion);
        } else {
            return ResponseEntity.badRequest().build();
        }

    }
}
