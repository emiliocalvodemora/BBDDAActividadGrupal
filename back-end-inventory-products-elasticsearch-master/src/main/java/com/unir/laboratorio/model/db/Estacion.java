package com.unir.laboratorio.model.db;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

@Document(indexName = "laboratorio", createIndex = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Estacion {
	
	@Id
	private String id;
	
	@MultiField(mainField = @Field(type = FieldType.Keyword, name = "name"),
		otherFields = @InnerField(suffix = "search", type = FieldType.Search_As_You_Type))
	private String name;
	
	@Field(type = FieldType.Text, name = "country")
	private String country;
	
	@Field(type = FieldType.Search_As_You_Type, name = "description")
	private String description;
	
	@Field(type = FieldType.Boolean, name = "visible")
	private Boolean visible;

}
