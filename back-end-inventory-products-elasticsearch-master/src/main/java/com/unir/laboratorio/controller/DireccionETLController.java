package com.unir.laboratorio.controller;

import com.unir.laboratorio.service.DireccionETLService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/etl/direccion")
@RequiredArgsConstructor
public class DireccionETLController {

    private final DireccionETLService direccionETLService;

    @GetMapping("/run")
    public ResponseEntity<String> ejecutarETL() {
        direccionETLService.ejecutarETL();
        return ResponseEntity.ok("ETL ejecutada correctamente para la tabla 'direccion'.");
    }
}
