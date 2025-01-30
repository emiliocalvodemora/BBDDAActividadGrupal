//package com.unir.laboratorio.data;

//import com.unir.laboratorio.model.db.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;

//public interface MunicipioRepository extends JpaRepository<Municipio, Integer> {

//}
package com.unir.laboratorio.data;

import com.unir.laboratorio.model.db.Municipio;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
import java.util.Optional;

public interface MunicipioRepository extends ElasticsearchRepository<Municipio, String> {

    List<Municipio> findByName(String name);

    Optional<Municipio> findById(String id);

    void delete(Municipio municipio);

    List<Municipio> findAll();
}