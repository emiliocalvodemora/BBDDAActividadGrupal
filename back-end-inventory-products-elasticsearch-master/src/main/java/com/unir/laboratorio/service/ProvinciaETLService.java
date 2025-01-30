package com.unir.laboratorio.service;

import com.unir.laboratorio.data.ProvinciaRepository;
import com.unir.laboratorio.data.ProvinciaElasticsearchRepository;
import com.unir.laboratorio.model.db.Provincia;
import com.unir.laboratorio.model.db.ProvinciaElasticsearch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProvinciaETLService {

    private final ProvinciaRepository mysqlRepository;
    private final ProvinciaElasticsearchRepository elasticsearchRepository;

    public void ejecutarETL() {
        List<Provincia> provincias = mysqlRepository.findAll();

        provincias.forEach(provincia -> {
            ProvinciaElasticsearch elasticProvincia = new ProvinciaElasticsearch();
            elasticProvincia.setNombre(provincia.getNombre());

            elasticsearchRepository.save(elasticProvincia);
        });

        System.out.println("ETL completada: Datos de provincias migrados a ElasticSearch.");
    }
}
