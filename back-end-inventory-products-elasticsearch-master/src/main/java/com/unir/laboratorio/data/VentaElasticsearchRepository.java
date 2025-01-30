package com.unir.laboratorio.data;

import com.unir.laboratorio.model.db.VentaElasticsearch;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaElasticsearchRepository extends ElasticsearchRepository<VentaElasticsearch, String> {

    VentaElasticsearch save(VentaElasticsearch venta);
}
