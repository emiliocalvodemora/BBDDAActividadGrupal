package com.unir.laboratorio.service;

import com.unir.laboratorio.data.DireccionRepository;
import com.unir.laboratorio.data.DireccionElasticsearchRepository;
import com.unir.laboratorio.model.db.Direccion;
import com.unir.laboratorio.model.db.DireccionElasticsearch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DireccionETLService {

    private final DireccionRepository mysqlRepository;
    private final DireccionElasticsearchRepository elasticsearchRepository;

    public void ejecutarETL() {
        List<Direccion> direcciones = mysqlRepository.findAll();

        direcciones.forEach(direccion -> {
            DireccionElasticsearch elasticDireccion = new DireccionElasticsearch();
            elasticDireccion.setId(direccion.getId().getDireccion() + "_" + direccion.getId().getCodigoPostal());
            elasticDireccion.setDireccion(direccion.getId().getDireccion());
            elasticDireccion.setCodigoPostal(direccion.getId().getCodigoPostal());
            elasticDireccion.setIdLocalidad(direccion.getIdLocalidad());

            elasticsearchRepository.save(elasticDireccion);
        });

        System.out.println("ETL completada: Datos de direcciones migrados a ElasticSearch.");
    }
}
