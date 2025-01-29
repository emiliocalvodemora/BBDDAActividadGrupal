package com.unir.laboratorio.data;

import com.unir.laboratorio.model.db.DireccionElasticsearch;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DireccionElasticsearchRepository extends ElasticsearchRepository<DireccionElasticsearch, String> {

}

