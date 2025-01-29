package com.unir.laboratorio.service;

import com.unir.laboratorio.data.CombustibleRepository;
import com.unir.laboratorio.data.CombustibleElasticsearchRepository;
import com.unir.laboratorio.model.db.Combustible;
import com.unir.laboratorio.model.db.CombustibleElasticsearch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CombustibleETLService {

    private final CombustibleRepository mysqlRepository;
    private final CombustibleElasticsearchRepository elasticsearchRepository;

    public void ejecutarETL() {
        // 1. Extraer datos desde MySQL
        List<Combustible> combustibles = mysqlRepository.findAll();

        // 2. Transformar y cargar en ElasticSearch
        combustibles.forEach(combustible -> {
            CombustibleElasticsearch elasticCombustible = new CombustibleElasticsearch();
            elasticCombustible.setTipoCombustible(combustible.getTipoCombustible());

            // Guardar en ElasticSearch
            elasticsearchRepository.save(elasticCombustible);
        });

        System.out.println("ETL completada: Datos de combustibles migrados a ElasticSearch.");
    }
}
