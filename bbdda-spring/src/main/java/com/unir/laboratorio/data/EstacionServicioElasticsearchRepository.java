package com.unir.laboratorio.data;

import com.unir.laboratorio.model.db.EstacionServicioElasticsearch;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstacionServicioElasticsearchRepository extends ElasticsearchRepository<EstacionServicioElasticsearch, String> {

}


