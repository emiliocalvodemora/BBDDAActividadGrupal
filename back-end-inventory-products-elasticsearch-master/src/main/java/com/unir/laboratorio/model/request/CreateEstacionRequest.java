package com.unir.laboratorio.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateEstacionRequest {

	private String name;
	private String country;
	private String description;
	private Boolean visible;
}
