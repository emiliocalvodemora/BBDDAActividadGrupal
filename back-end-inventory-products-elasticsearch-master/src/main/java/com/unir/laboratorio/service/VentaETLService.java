package com.unir.laboratorio.service;

import com.unir.laboratorio.data.VentaRepository;
import com.unir.laboratorio.data.VentaElasticsearchRepository;
import com.unir.laboratorio.model.db.Venta;
import com.unir.laboratorio.model.db.VentaElasticsearch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VentaETLService {

    private final VentaRepository mysqlRepository;
    private final VentaElasticsearchRepository elasticsearchRepository;

    public void ejecutarETL() {
        List<Venta> ventas = mysqlRepository.findAll();

        ventas.forEach(venta -> {
            VentaElasticsearch elasticVenta = new VentaElasticsearch();
            elasticVenta.setId(venta.getId().getLatitud() + "_" + venta.getId().getLongitud() + "_" + venta.getId().getTipoCombustible());
            elasticVenta.setLatitud(venta.getId().getLatitud());
            elasticVenta.setLongitud(venta.getId().getLongitud());
            elasticVenta.setTipoCombustible(venta.getId().getTipoCombustible());
            elasticVenta.setPrecio(venta.getPrecio());
            elasticVenta.setRem(venta.getRem());

            elasticsearchRepository.save(elasticVenta);
        });

        System.out.println("ETL completada: Datos de ventas migrados a ElasticSearch.");
    }
}
