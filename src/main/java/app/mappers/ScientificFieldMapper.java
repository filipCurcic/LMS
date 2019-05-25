package app.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.dto.ScientificFieldDto;
import app.entities.ScientificField;


@Component
public class ScientificFieldMapper implements Mapper<ScientificField, ScientificFieldDto> {

	

	public ScientificFieldDto toDTO(ScientificField cientificField) {
		ScientificFieldDto retVal = new ScientificFieldDto();
			retVal.setId(cientificField.getId());
			retVal.setName(cientificField.getName());
			retVal.setVersion(cientificField.getVersion());
			//retVal.setCity(new ArrayList<>());
			
			//retVal.setCity(CityMapper.toDTO(country.g));
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
