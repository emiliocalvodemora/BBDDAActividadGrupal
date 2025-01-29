package com.unir.laboratorio.data;

import com.unir.laboratorio.model.db.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, String> {

}

