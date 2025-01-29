package com.unir.laboratorio.data;

import com.unir.laboratorio.model.db.Combustible;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CombustibleRepository extends JpaRepository<Combustible, String> {

}
