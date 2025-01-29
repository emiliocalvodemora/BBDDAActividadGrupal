package com.unir.laboratorio.controller;

import com.unir.laboratorio.service.EstacionServicioETLService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/etl/estacion-servicio")
@RequiredArgsConstructor
public class EstacionServicioETLController {

    private final EstacionServicioETLService estacionServicioETLService;

    @GetMapping("/run")
    public ResponseEntity<String> ejecutarETL() {
        estacionServicioETLService.ejecutarETL();
        return ResponseEntity.ok("ETL ejecutada correctamente para la tabla 'estacion_servicio'.");
    }
}
