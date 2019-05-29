package app.mappers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import app.dto.ScientificFieldDto;
import app.entities.ScientificField;
import app.entities.Title;


@Component
public class ScientificFieldMapper implements Mapper<ScientificField, ScientificFieldDto> {


	public ScientificFieldDto toDTO(ScientificField scientificField) {
		
		if(scientificField == null) {
			return null;
		}
		
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
		if(scientificFieldDto == null) {
			return null;		
		}
		
		ScientificField scientificField = new ScientificField();
		
		scientificField.setId(scientificFieldDto.getId());
		scientificField.setName(scientificFieldDto.getName());
		scientificField.setVersion(scientificFieldDto.getVersion());
		return scientificField;
	}
	
	public List<ScientificFieldDto> toDTO(List<ScientificField> scientificField){
		
		if(scientificField == null) {
			return null;
		}
		
		List<ScientificFieldDto > retVal = new ArrayList<ScientificFieldDto >();
		for (ScientificField scientificFields: scientificField) {
			retVal.add(toDTO(scientificFields));
		}
		return retVal;
	}

	public Collection<ScientificField> toEntity(Collection<ScientificFieldDto > scientificFieldDto){
		if(scientificFieldDto == null) {
			return null;
		}
		
		Collection<ScientificField> scientificField = new ArrayList<ScientificField>(scientificFieldDto.size());
		for(ScientificFieldDto sDto: scientificFieldDto) {
			scientificField.add(toEntity(sDto));
		}
		
		return scientificField;
		
	}

}
