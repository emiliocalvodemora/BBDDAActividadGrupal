package com.unir.laboratorio.model.response;

import com.unir.laboratorio.model.db.EstacionServicio;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EstacionesServicioQueryResponse {

    private List<EstacionServicio> EstacionesServicio;
    private List<AggregationDetails> aggs;

}
