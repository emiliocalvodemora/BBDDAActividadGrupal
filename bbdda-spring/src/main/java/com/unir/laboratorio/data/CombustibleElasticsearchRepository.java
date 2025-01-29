package com.unir.laboratorio.data;

import com.unir.laboratorio.model.db.CombustibleElasticsearch;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CombustibleElasticsearchRepository extends ElasticsearchRepository<CombustibleElasticsearch, String> {

}
