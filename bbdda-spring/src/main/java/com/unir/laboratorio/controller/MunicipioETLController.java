package com.unir.laboratorio.controller;

import com.unir.laboratorio.service.MunicipioETLService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/etl/municipio")
@RequiredArgsConstructor
public class MunicipioETLController {

    private final MunicipioETLService municipioETLService;

    @GetMapping("/run")
    public ResponseEntity<String> ejecutarETL() {
        municipioETLService.ejecutarETL();
        return ResponseEntity.ok("ETL ejecutada correctamente para la tabla 'municipio'.");
    }
}
