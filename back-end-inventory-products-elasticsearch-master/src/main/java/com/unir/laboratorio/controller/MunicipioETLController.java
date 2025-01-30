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

//import com.unir.laboratorio.model.db.Municipio;
//import com.unir.laboratorio.model.request.CreateMunicipioRequest;
//import com.unir.laboratorio.model.response.MunicipiosQueryResponse;
//import com.unir.laboratorio.service.MunicipioService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Map;
//
//@RestController
//@RequiredArgsConstructor
//@Slf4j
//public class MunicipioETLController {
//
//    private final MunicipioETLService service;
//
//    @GetMapping("/municipios")
//    public ResponseEntity<MunicipiosQueryResponse> getMunicipios(
//            @RequestHeader Map<String, String> headers,
//            @RequestParam(required = false) String name,
//            @RequestParam(required = false) String province) {
//
//        log.info("headers: {}", headers);
//        MunicipiosQueryResponse municipios = service.getMunicipios(name, province);
//        return ResponseEntity.ok(municipios);
//    }
//
//    @GetMapping("/municipios/{municipioId}")
//    public ResponseEntity<Municipio> getMunicipio(@PathVariable String municipioId) {
//
//        log.info("Request received for municipio {}", municipioId);
//        Municipio municipio = service.getMunicipio(municipioId);
//
//        if (municipio != null) {
//            return ResponseEntity.ok(municipio);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//
//    @DeleteMapping("/municipios/{municipioId}")
//    public ResponseEntity<Void> deleteMunicipio(@PathVariable String municipioId) {
//
//        Boolean removed = service.removeMunicipio(municipioId);
//
//        if (Boolean.TRUE.equals(removed)) {
//            return ResponseEntity.ok().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//
//    }
//
//    @PostMapping("/municipios")
//    public ResponseEntity<Municipio> createMunicipio(@RequestBody CreateMunicipioRequest request) {
//
//        Municipio createdMunicipio = service.createMunicipio(request);
//
//        if (createdMunicipio != null) {
//            return ResponseEntity.status(HttpStatus.CREATED).body(createdMunicipio);
//        } else {
//            return ResponseEntity.badRequest().build();
//        }
//
//    }
//}