package com.unir.laboratorio.data;

import com.unir.laboratorio.model.db.Provincia;
import com.unir.laboratorio.model.db.ProvinciaElasticsearch;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProvinciaElasticsearchRepository extends ElasticsearchRepository<ProvinciaElasticsearch, String> {

    List<Provincia> findByName(String name);

    Optional<Provincia> findById(String id);

    ProvinciaElasticsearch save(ProvinciaElasticsearch provincia);

    void delete(Provincia provincia);

    List<Provincia> findAll();
}
