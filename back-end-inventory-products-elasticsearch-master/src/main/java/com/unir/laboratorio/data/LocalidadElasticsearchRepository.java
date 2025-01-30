package com.unir.laboratorio.data;

import com.unir.laboratorio.model.db.LocalidadElasticsearch;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalidadElasticsearchRepository extends ElasticsearchRepository<LocalidadElasticsearch, Integer> {
    LocalidadElasticsearch save(LocalidadElasticsearch localidad);
}
