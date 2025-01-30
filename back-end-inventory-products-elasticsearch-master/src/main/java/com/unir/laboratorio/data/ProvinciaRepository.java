//package com.unir.laboratorio.data;

//import com.unir.laboratorio.model.db.Provincia;
//import org.springframework.data.jpa.repository.JpaRepository;

//public interface ProvinciaRepository extends JpaRepository<Provincia, String> {

//}
package com.unir.laboratorio.data;

import com.unir.laboratorio.model.db.Provincia;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
import java.util.Optional;

public interface ProvinciaRepository extends ElasticsearchRepository<Provincia, String> {

    List<Provincia> findByName(String name);

    Optional<Provincia> findById(String id);

    Provincia save(Provincia provincia);

    void delete(Provincia provincia);

    List<Provincia> findAll();
}