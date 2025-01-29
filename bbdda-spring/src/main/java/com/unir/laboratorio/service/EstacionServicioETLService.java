package com.unir.laboratorio.service;

import com.unir.laboratorio.data.EstacionServicioRepository;
import com.unir.laboratorio.data.EstacionServicioElasticsearchRepository;
import com.unir.laboratorio.model.db.EstacionServicio;
import com.unir.laboratorio.model.db.EstacionServicioElasticsearch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EstacionServicioETLService {

    private final EstacionServicioRepository mysqlRepository;
    private final EstacionServicioElasticsearchRepository elasticsearchRepository;

    public void ejecutarETL() {
        List<EstacionServicio> estaciones = mysqlRepository.findAll();

        estaciones.forEach(estacion -> {
            EstacionServicioElasticsearch elasticEstacion = new EstacionServicioElasticsearch();
            elasticEstacion.setId(estacion.getId().getLatitud() + "_" + estacion.getId().getLongitud());
            elasticEstacion.setEmpresa(estacion.getEmpresa());
            elasticEstacion.setDireccion(estacion.getDireccion());
            elasticEstacion.setCodigoPostal(estacion.getCodigoPostal());
            elasticEstacion.setHorario(estacion.getHorario());
            elasticEstacion.setMargen(estacion.getMargen());
            elasticEstacion.setTipoEstacion(estacion.getTipoEstacion());
            elasticEstacion.setTipoVenta(estacion.getTipoVenta());
            elasticEstacion.setFechaActualizacion(estacion.getFechaActualizacion());

            elasticsearchRepository.save(elasticEstacion);
        });

        System.out.println("ETL completada: Datos de estaciones migrados a ElasticSearch.");
    }
}
