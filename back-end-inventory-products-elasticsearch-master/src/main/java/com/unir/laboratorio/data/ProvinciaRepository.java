package com.unir.laboratorio.data;

import com.unir.laboratorio.model.db.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvinciaRepository extends JpaRepository<Provincia, String> {

}