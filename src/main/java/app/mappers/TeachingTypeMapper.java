package app.mappers;

import java.util.ArrayList;
import java.util.Collection;
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
		
		if(teachingType == null) {
			return null;
		}
		
		TeachingTypeDto retVal = new TeachingTypeDto();
			retVal.setId(teachingType.getId());
			retVal.setName(teachingType.getName());
			retVal.setVersion(teachingType.getVersion());
			retVal.setTeacherOnRealizationDto(new TeacherOnRealizationDto());
			retVal.setTeacherOnRealizationDto(teacherOnRealizationMapper.toDTO(teachingType.getTeacherOnRealization()));
			return retVal;

	}
	
	public TeachingType toEntity(TeachingTypeDto teachingTypeDto) {
		if(teachingTypeDto == null) {
			return null;		
		}
		
		TeachingType teachingType = new TeachingType();
		
		teachingType.setId(teachingTypeDto.getId());
		teachingType.setName(teachingTypeDto.getName());
		teachingType.setVersion(teachingTypeDto.getVersion());
		teachingType.setTeacherOnRealization(teacherOnRealizationMapper.toEntity(teachingTypeDto.getTeacherOnRealizationDto()));
		
		return teachingType;
	}
	
	public List<TeachingTypeDto> toDTO(List<TeachingType> teachingType){
		
		if(teachingType == null) {
			return null;
		}
		
		List<TeachingTypeDto > retVal = new ArrayList<TeachingTypeDto >();
		for (TeachingType teachingTypes: teachingType) {
			retVal.add(toDTO(teachingTypes));
		}
		return retVal;
	}

	public Collection<TeachingType> toEntity(Collection<TeachingTypeDto > teachingTypeDto){
		if(teachingTypeDto == null) {
			return null;
		}
		
		Collection<TeachingType> teachingType = new ArrayList<TeachingType>(teachingTypeDto.size());
		for(TeachingTypeDto tDto: teachingTypeDto) {
			teachingType.add(toEntity(tDto));
		}
		
		return teachingType;
	}


}
