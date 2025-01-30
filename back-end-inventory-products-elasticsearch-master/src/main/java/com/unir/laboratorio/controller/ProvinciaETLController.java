//package com.unir.laboratorio.controller;

//import com.unir.laboratorio.service.ProvinciaETLService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/api/etl/provincia")
//@RequiredArgsConstructor
//public class ProvinciaETLController {

//    private final ProvinciaETLService provinciaETLService;

//    @GetMapping("/run")
//    public ResponseEntity<String> ejecutarETL() {
//        provinciaETLService.ejecutarETL();
//        return ResponseEntity.ok("ETL ejecutada correctamente para la tabla 'provincia'.");
//    }
//}
package com.unir.laboratorio.controller;

import com.unir.laboratorio.model.db.Provincia;
import com.unir.laboratorio.model.request.CreateProvinciaRequest;
import com.unir.laboratorio.model.response.ProvinciasQueryResponse;
import com.unir.laboratorio.service.ProvinciaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ProvinciaETLController {

    private final ProvinciaService service;

    @GetMapping("/provincias")
    public ResponseEntity<ProvinciasQueryResponse> getProvincias(
            @RequestHeader Map<String, String> headers,
            @RequestParam(required = false) String name) {

        log.info("headers: {}", headers);
        ProvinciasQueryResponse provincias = service.getProvincias(name);
        return ResponseEntity.ok(provincias);
    }


    @GetMapping("/provincias/{provinciaId}")
    public ResponseEntity<Provincia> getProvincia(@PathVariable String provinciaId) {

        log.info("Request received for provincia {}", provinciaId);
        Provincia provincia = service.getProvincia(provinciaId);

        if (provincia != null) {
            return ResponseEntity.ok(provincia);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/provincias/{provinciaId}")
    public ResponseEntity<Void> deleteProvincia(@PathVariable String provinciaId) {

        Boolean removed = service.removeProvincia(provinciaId);

        if (Boolean.TRUE.equals(removed)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/provincias")
    public ResponseEntity<Provincia> createProvincia(@RequestBody CreateProvinciaRequest request) {

        Provincia createdProvincia = service.createProvincia(request);

        if (createdProvincia != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdProvincia);
        } else {
            return ResponseEntity.badRequest().build();
        }

    }
}