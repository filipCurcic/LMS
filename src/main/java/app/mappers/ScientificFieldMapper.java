package app.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import app.dto.ScientificFieldDto;
import app.entities.ScientificField;
import app.entities.Title;


@Component
public class ScientificFieldMapper implements Mapper<ScientificField, ScientificFieldDto> {


	public ScientificFieldDto toDTO(ScientificField scientificField) {
		ScientificFieldDto retVal = new ScientificFieldDto();
			retVal.setId(scientificField.getId());
			retVal.setName(scientificField.getName());
			retVal.setVersion(scientificField.getVersion());
			retVal.setTitle(new ArrayList<>());
			for(Title title: scientificField.getTitle()) {
				retVal.getTitle().add("/title/" + title.getId());
			}
			return retVal;

	}
	
	public ScientificField toEntity(ScientificFieldDto scientificFieldDto) {
		return null;		
	}
	
	public List<ScientificFieldDto> toDTO(List<ScientificField> scientificField){
		List<ScientificFieldDto > retVal = new ArrayList<ScientificFieldDto >();
		for (ScientificField scientificFields: scientificField) {
			retVal.add(toDTO(scientificFields));
		}
		return retVal;
	}

	public List<ScientificField> toEntity(List<ScientificFieldDto > scientificFieldDto){
		return null;
	}

}
