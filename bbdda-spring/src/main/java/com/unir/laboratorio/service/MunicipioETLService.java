package com.unir.laboratorio.service;

import com.unir.laboratorio.data.MunicipioRepository;
import com.unir.laboratorio.data.MunicipioElasticsearchRepository;
import com.unir.laboratorio.model.db.Municipio;
import com.unir.laboratorio.model.db.MunicipioElasticsearch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MunicipioETLService {

    private final MunicipioRepository mysqlRepository;
    private final MunicipioElasticsearchRepository elasticsearchRepository;

    public void ejecutarETL() {
        List<Municipio> municipios = mysqlRepository.findAll();

        municipios.forEach(municipio -> {
            MunicipioElasticsearch elasticMunicipio = new MunicipioElasticsearch();
            elasticMunicipio.setIdMunicipio(municipio.getIdMunicipio());
            elasticMunicipio.setNombreMunicipio(municipio.getNombreMunicipio());
            elasticMunicipio.setProvincia(municipio.getProvincia());

            elasticsearchRepository.save(elasticMunicipio);
        });

        System.out.println("ETL completada: Datos de municipios migrados a ElasticSearch.");
    }
}
