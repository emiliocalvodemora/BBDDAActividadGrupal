package com.unir.laboratorio.data;

import com.unir.laboratorio.model.db.EstacionServicio;
import com.unir.laboratorio.model.db.EstacionServicioId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstacionServicioRepository extends JpaRepository<EstacionServicio, EstacionServicioId> {

}

