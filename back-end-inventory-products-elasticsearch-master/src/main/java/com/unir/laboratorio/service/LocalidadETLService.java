package com.unir.laboratorio.service;

import com.unir.laboratorio.data.LocalidadRepository;
import com.unir.laboratorio.data.LocalidadElasticsearchRepository;
import com.unir.laboratorio.model.db.Localidad;
import com.unir.laboratorio.model.db.LocalidadElasticsearch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocalidadETLService {

    private final LocalidadRepository mysqlRepository;
    private final LocalidadElasticsearchRepository elasticsearchRepository;

    public void ejecutarETL() {
        List<Localidad> localidades = mysqlRepository.findAll();

        localidades.forEach(localidad -> {
            LocalidadElasticsearch elasticLocalidad = new LocalidadElasticsearch();
            elasticLocalidad.setIdLocalidad(localidad.getIdLocalidad());
            elasticLocalidad.setIdMunicipio(localidad.getIdMunicipio());
            elasticLocalidad.setNombreLocalidad(localidad.getNombreLocalidad());

            elasticsearchRepository.save(elasticLocalidad);
        });

        System.out.println("ETL completada: Datos de localidades migrados a ElasticSearch.");
    }
}
