package com.unir.laboratorio.controller;

import com.unir.laboratorio.service.CombustibleETLService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/etl/combustible")
@RequiredArgsConstructor
public class CombustibleETLController {

    private final CombustibleETLService combustibleETLService;

    @GetMapping("/run")
    public ResponseEntity<String> ejecutarETL() {
        combustibleETLService.ejecutarETL();
        return ResponseEntity.ok("ETL ejecutada correctamente para la tabla 'combustible'.");
    }
}
