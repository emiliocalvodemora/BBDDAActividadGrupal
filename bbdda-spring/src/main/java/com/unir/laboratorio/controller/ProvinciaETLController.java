package com.unir.laboratorio.controller;

import com.unir.laboratorio.service.ProvinciaETLService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/etl/provincia")
@RequiredArgsConstructor
public class ProvinciaETLController {

    private final ProvinciaETLService provinciaETLService;

    @GetMapping("/run")
    public ResponseEntity<String> ejecutarETL() {
        provinciaETLService.ejecutarETL();
        return ResponseEntity.ok("ETL ejecutada correctamente para la tabla 'provincia'.");
    }
}
