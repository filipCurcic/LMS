package app.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.dto.TeacherOnRealizationDto;
import app.dto.TeachingTypeDto;
import app.entities.TeachingType;

@Component
public class TeachingTypeMapper implements Mapper<TeachingType, TeachingTypeDto> {

	@Autowired
	TeacherOnRealizationMapper teacherOnRealizationMapper;
	
	public TeachingTypeDto toDTO(TeachingType teachingType) {
		TeachingTypeDto retVal = new TeachingTypeDto();
			retVal.setId(teachingType.getId());
			retVal.setName(teachingType.getName());
			retVal.setVersion(teachingType.getVersion());
			retVal.setTeacherOnRealizationDto(new TeacherOnRealizationDto());
			retVal.setTeacherOnRealizationDto(teacherOnRealizationMapper.toDTO(teachingType.getTeacherOnRealization()));
			return retVal;

	}
	
	public TeachingType toEntity(TeachingTypeDto teachingTypeDto) {
		return null;		
	}
	
	public List<TeachingTypeDto> toDTO(List<TeachingType> teachingType){
		List<TeachingTypeDto > retVal = new ArrayList<TeachingTypeDto >();
		for (TeachingType teachingTypes: teachingType) {
			retVal.add(toDTO(teachingTypes));
		}
		return retVal;
	}

	public List<TeachingType> toEntity(List<TeachingTypeDto > teachingTypeDto){
		return null;
	}


}
