package com.unir.laboratorio.data;

import com.unir.laboratorio.model.db.Empresa;
import com.unir.laboratorio.model.db.EmpresaElasticsearch;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaElasticsearchRepository extends ElasticsearchRepository<EmpresaElasticsearch, String> {
    EmpresaElasticsearch save(EmpresaElasticsearch empresa);
}
