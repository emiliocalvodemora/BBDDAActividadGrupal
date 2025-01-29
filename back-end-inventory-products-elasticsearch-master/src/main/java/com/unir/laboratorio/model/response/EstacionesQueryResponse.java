package com.unir.laboratorio.model.response;

import com.unir.laboratorio.model.db.Estacion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EstacionesQueryResponse {

    private List<Estacion> products;
    private List<AggregationDetails> aggs;

}
