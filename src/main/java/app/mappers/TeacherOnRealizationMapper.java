package app.mappers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.dto.TeacherOnRealizationDto;
import app.entities.TeacherOnRealization;

@Component
public class TeacherOnRealizationMapper implements Mapper<TeacherOnRealization, TeacherOnRealizationDto> {
	
	@Autowired
	TeacherMapper teacherMapper;
	
	@Autowired
	TeachingTypeMapper teacherTypeMapper;
	
	public TeacherOnRealizationDto toDTO(TeacherOnRealization teacherOnRealization) {
		
		if(teacherOnRealization == null) {
			return null;
		}
		
		TeacherOnRealizationDto retVal = new TeacherOnRealizationDto();
			retVal.setId(teacherOnRealization.getId());
			retVal.setNumberOfClasses(teacherOnRealization.getNumberOfClasses());
			retVal.setVersion(teacherOnRealization.getVersion());
			retVal.setTeacherDto(teacherMapper.toDTO(teacherOnRealization.getTeacher()));
			retVal.setTeachingTypeDto(teacherTypeMapper.toDTO(teacherOnRealization.getTeachingType()));
			return retVal;

	}
	
	public TeacherOnRealization toEntity(TeacherOnRealizationDto teacherOnRealizationDto) {
		if(teacherOnRealizationDto == null) {
			return null;		
		}
		
		TeacherOnRealization teacherOnRealization = new TeacherOnRealization();
		
		teacherOnRealization.setId(teacherOnRealizationDto.getId());
		teacherOnRealization.setNumberOfClasses(teacherOnRealizationDto.getNumberOfClasses());
		teacherOnRealization.setVersion(teacherOnRealizationDto.getVersion());
		teacherOnRealization.setTeachingType(teacherTypeMapper.toEntity(teacherOnRealizationDto.getTeachingTypeDto()));
		teacherOnRealization.setTeacher(teacherMapper.toEntity(teacherOnRealizationDto.getTeacherDto()));
		
		return teacherOnRealization;
		
	}
	
	public List<TeacherOnRealizationDto> toDTO(List<TeacherOnRealization> teacherOnRealization){
		
		if(teacherOnRealization == null) {
			return null;
		}
		
		List<TeacherOnRealizationDto > retVal = new ArrayList<TeacherOnRealizationDto >();
		for (TeacherOnRealization teacherOnRealizations: teacherOnRealization) {
			retVal.add(toDTO(teacherOnRealizations));
		}
		return retVal;
	}

	public Collection<TeacherOnRealization> toEntity(Collection<TeacherOnRealizationDto > teacherOnRealizationDto){
		if(teacherOnRealizationDto == null) {
			return null;
		}
		
		Collection<TeacherOnRealization> teacherOnRealization = new ArrayList<TeacherOnRealization>(teacherOnRealizationDto.size());
		for(TeacherOnRealizationDto tDto: teacherOnRealizationDto) {
			teacherOnRealization.add(toEntity(tDto));
		}
		
		return teacherOnRealization;
	}



}
