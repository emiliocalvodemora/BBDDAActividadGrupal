package com.unir.laboratorio.data;

import com.unir.laboratorio.model.db.Venta;
import com.unir.laboratorio.model.db.VentaId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta, VentaId> {

}

