package com.unir.laboratorio.data;

import com.unir.laboratorio.model.db.Estacion;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
import java.util.Optional;

public interface EstacionRepository extends ElasticsearchRepository<Estacion, String> {

	List<Estacion> findByName(String name);
	
	Optional<Estacion> findById(String id);

	Estacion save(Estacion estacion);
	
	void delete(Estacion estacion);
	
	List<Estacion> findAll();
}
