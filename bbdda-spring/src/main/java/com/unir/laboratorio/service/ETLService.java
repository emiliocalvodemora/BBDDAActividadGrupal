package com.unir.laboratorio.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ETLService {

    private final DireccionETLService direccionETLService;
    private final EstacionServicioETLService estacionServicioETLService;
    private final VentaETLService ventaETLService;
    private final EmpresaETLService empresaETLService;
    private final CombustibleETLService combustibleETLService;
    private final ProvinciaETLService provinciaETLService;
    private final MunicipioETLService municipioETLService;
    private final LocalidadETLService localidadETLService;

    public void ejecutarTodasETL() {
        System.out.println("Iniciando todas las ETL...");

        direccionETLService.ejecutarETL();
        estacionServicioETLService.ejecutarETL();
        ventaETLService.ejecutarETL();
        empresaETLService.ejecutarETL();
        combustibleETLService.ejecutarETL();
        provinciaETLService.ejecutarETL();
        municipioETLService.ejecutarETL();
        localidadETLService.ejecutarETL();

        System.out.println("Todas las ETL se han ejecutado correctamente.");
    }
}

