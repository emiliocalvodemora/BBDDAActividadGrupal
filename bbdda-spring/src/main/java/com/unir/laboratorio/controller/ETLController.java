package com.unir.laboratorio.controller;

import com.unir.laboratorio.service.ETLService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/etl")
@RequiredArgsConstructor
public class ETLController {

    private final ETLService etlService;

    /**
     * Endpoint para ejecutar la ETL manualmente.
     * Llamar a este endpoint migrará los datos de MySQL a ElasticSearch.
     *
     * @return Mensaje de confirmación.
     */
    @GetMapping("/run")
    public ResponseEntity<String> ejecutarETL() {
        etlService.ejecutarTodasETL();
        return ResponseEntity.ok("ETL ejecutada correctamente. Datos migrados a ElasticSearch.");
    }
}

