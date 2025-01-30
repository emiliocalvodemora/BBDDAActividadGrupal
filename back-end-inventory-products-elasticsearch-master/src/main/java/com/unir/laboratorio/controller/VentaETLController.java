package com.unir.laboratorio.controller;

import com.unir.laboratorio.service.VentaETLService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/etl/venta")
@RequiredArgsConstructor
public class VentaETLController {

    private final VentaETLService ventaETLService;

    @GetMapping("/run")
    public ResponseEntity<String> ejecutarETL() {
        ventaETLService.ejecutarETL();
        return ResponseEntity.ok("ETL ejecutada correctamente para la tabla 'venta'.");
    }
}

