package com.unir.laboratorio.data;

import com.unir.laboratorio.model.db.Direccion;
import com.unir.laboratorio.model.db.DireccionId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DireccionRepository extends JpaRepository<Direccion, DireccionId> {
    // Métodos personalizados si son necesarios
}
