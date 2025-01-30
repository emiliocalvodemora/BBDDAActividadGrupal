package com.unir.laboratorio.data;

import com.unir.laboratorio.model.db.EstacionServicio;
import com.unir.laboratorio.model.db.EstacionServicioElasticsearch;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstacionServicioElasticsearchRepository extends ElasticsearchRepository<EstacionServicioElasticsearch, String> {

    List<EstacionServicio> findByName(String name);

    Optional<EstacionServicio> findById(String id);

    EstacionServicioElasticsearch save(EstacionServicioElasticsearch estacionServicio);

    void delete(EstacionServicio estacionServicio);

    List<EstacionServicio> findAll();
}


