package com.unir.laboratorio.data;

import com.unir.laboratorio.model.db.ProvinciaElasticsearch;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinciaElasticsearchRepository extends ElasticsearchRepository<ProvinciaElasticsearch, String> {

}
