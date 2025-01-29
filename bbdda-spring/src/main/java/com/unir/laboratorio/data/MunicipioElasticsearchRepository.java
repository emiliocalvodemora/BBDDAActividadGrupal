package com.unir.laboratorio.data;

import com.unir.laboratorio.model.db.MunicipioElasticsearch;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MunicipioElasticsearchRepository extends ElasticsearchRepository<MunicipioElasticsearch, Integer> {

}
