package com.unir.laboratorio.service;

import com.unir.laboratorio.data.EmpresaRepository;
import com.unir.laboratorio.data.EmpresaElasticsearchRepository;
import com.unir.laboratorio.model.db.Empresa;
import com.unir.laboratorio.model.db.EmpresaElasticsearch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpresaETLService {

    private final EmpresaRepository mysqlRepository;
    private final EmpresaElasticsearchRepository elasticsearchRepository;

    public void ejecutarETL() {
        List<Empresa> empresas = mysqlRepository.findAll();

        empresas.forEach(empresa -> {
            EmpresaElasticsearch elasticEmpresa = new EmpresaElasticsearch();
            elasticEmpresa.setNombre(empresa.getNombre());

            elasticsearchRepository.save(elasticEmpresa);
        });

        System.out.println("ETL completada: Datos de empresas migrados a ElasticSearch.");
    }
}
