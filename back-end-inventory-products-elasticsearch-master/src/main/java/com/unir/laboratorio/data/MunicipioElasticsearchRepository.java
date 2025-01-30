package com.unir.laboratorio.data;

import com.unir.laboratorio.model.db.Municipio;
import com.unir.laboratorio.model.db.MunicipioElasticsearch;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;
@Repository
public interface MunicipioElasticsearchRepository extends ElasticsearchRepository<MunicipioElasticsearch, Integer> {

    List<Municipio> findByName(String name);

    Optional<Municipio> findById(String id);

    void delete(Municipio municipio);

    List<Municipio> findAll();

    MunicipioElasticsearch save(MunicipioElasticsearch municipio);
}
