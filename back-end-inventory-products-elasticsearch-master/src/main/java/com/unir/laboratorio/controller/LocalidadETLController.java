package com.unir.laboratorio.controller;

import com.unir.laboratorio.service.LocalidadETLService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/etl/localidad")
@RequiredArgsConstructor
public class LocalidadETLController {

    private final LocalidadETLService localidadETLService;

    @GetMapping("/run")
    public ResponseEntity<String> ejecutarETL() {
        localidadETLService.ejecutarETL();
        return ResponseEntity.ok("ETL ejecutada correctamente para la tabla 'localidad'.");
    }
}
