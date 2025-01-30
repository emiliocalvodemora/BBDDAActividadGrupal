package com.unir.laboratorio.controller;

import com.unir.laboratorio.service.EmpresaETLService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/etl/empresa")
@RequiredArgsConstructor
public class EmpresaETLController {

    private final EmpresaETLService empresaETLService;

    @GetMapping("/run")
    public ResponseEntity<String> ejecutarETL() {
        empresaETLService.ejecutarETL();
        return ResponseEntity.ok("ETL ejecutada correctamente para la tabla 'empresa'.");
    }
}
