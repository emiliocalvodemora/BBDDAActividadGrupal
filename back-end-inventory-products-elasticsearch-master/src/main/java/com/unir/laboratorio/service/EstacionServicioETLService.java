package com.unir.laboratorio.service;

import com.unir.laboratorio.data.EstacionServicioRepository;
import com.unir.laboratorio.data.EstacionServicioElasticsearchRepository;
import com.unir.laboratorio.model.db.EstacionServicio;
import com.unir.laboratorio.model.db.EstacionServicioElasticsearch;
import com.unir.laboratorio.model.response.AggregationDetails;
import com.unir.laboratorio.model.response.EstacionesServicioQueryResponse;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.bucket.terms.ParsedStringTerms;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EstacionServicioETLService {

    @Value("${server.fullAddress}")
    private String serverFullAddress;

    private final EstacionServicioRepository mysqlRepository;
    private final EstacionServicioElasticsearchRepository elasticsearchRepository;

    private final ElasticsearchOperations elasticClient;

    public void ejecutarETL() {
        List<EstacionServicio> estaciones = mysqlRepository.findAll();

        estaciones.forEach(estacion -> {
            EstacionServicioElasticsearch elasticEstacion = new EstacionServicioElasticsearch();
            elasticEstacion.setId(estacion.getId().getLatitud() + "_" + estacion.getId().getLongitud());
            elasticEstacion.setEmpresa(estacion.getEmpresa());
            elasticEstacion.setDireccion(estacion.getDireccion());
            elasticEstacion.setCodigoPostal(estacion.getCodigoPostal());
            elasticEstacion.setHorario(estacion.getHorario());
            elasticEstacion.setMargen(estacion.getMargen());
            elasticEstacion.setTipoEstacion(estacion.getTipoEstacion());
            elasticEstacion.setTipoVenta(estacion.getTipoVenta());
            elasticEstacion.setFechaActualizacion(estacion.getFechaActualizacion());

            elasticsearchRepository.save(elasticEstacion);
        });

        System.out.println("ETL completada: Datos de estaciones migrados a ElasticSearch.");
    }

    public Optional<EstacionServicio> getEstacionServicio(String id) {
        return elasticsearchRepository.findById(id);
    }

    public EstacionesServicioQueryResponse getEstaciones(double latitud, double longitud, String empresa, String direccion, int codigoPostal, String horario, String margen, String tipoEstacion, String tipoVenta, String fechaActualizacion) {


        BoolQueryBuilder querySpec = QueryBuilders.boolQuery();

        if (!StringUtils.isEmpty(empresa)) {
            querySpec.must(QueryBuilders.termQuery("empresa", empresa));
        }

        if (!StringUtils.isEmpty(direccion)) {
            querySpec.must(QueryBuilders.matchQuery("direccion", direccion));
        }


        //Si no he recibido ningun parametro, busco todos los elementos.
        if (!querySpec.hasClauses()) {
            querySpec.must(QueryBuilders.matchAllQuery());
        }

        //Filtro implicito
        //No le pido al usuario que lo introduzca pero lo aplicamos proactivamente en todas las peticiones
        querySpec.must(QueryBuilders.termQuery("visible", true));

        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder().withQuery(querySpec);


        //Opcionalmente, podemos paginar los resultados
        //nativeSearchQueryBuilder.withPageable(PageRequest.of(0, 10));

        Query query = nativeSearchQueryBuilder.build();
        SearchHits<EstacionServicio> result = elasticClient.search(query, EstacionServicio.class);

        List<AggregationDetails> responseAggs = new LinkedList<>();

        if (result.hasAggregations()) {
            Map<String, Aggregation> aggs = result.getAggregations().asMap();
            ParsedStringTerms countryAgg = (ParsedStringTerms) aggs.get("Country Aggregation");

            //Componemos una URI basada en serverFullAddress y query params para cada argumento, siempre que no viniesen vacios
            String queryParams = getQueryParams(latitud, longitud, empresa, direccion, codigoPostal, horario, margen, tipoEstacion, tipoVenta, fechaActualizacion);
            countryAgg.getBuckets()
                    .forEach(
                            bucket -> responseAggs.add(
                                    new AggregationDetails(
                                            bucket.getKey().toString(),
                                            (int) bucket.getDocCount(),
                                            serverFullAddress + "/laboratorio?country=" + bucket.getKey() + queryParams)));
        }
        return new EstacionesServicioQueryResponse(result.getSearchHits().stream().map(SearchHit::getContent).toList(), responseAggs);

    }

    private String getQueryParams(double latitud, double longitud, String empresa, String direccion, int codigoPostal, String horario, String margen, String tipoEstacion, String tipoVenta, String fechaActualizacion) {
        String queryParams = (StringUtils.isEmpty(empresa) ? "" : "&empresa=" + empresa)
                + (StringUtils.isEmpty(direccion) ? "" : "&direccion=" + direccion);
        // Eliminamos el ultimo & si existe
        return queryParams.endsWith("&") ? queryParams.substring(0, queryParams.length() - 1) : queryParams;
    }
}
