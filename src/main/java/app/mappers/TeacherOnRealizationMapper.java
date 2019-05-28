package app.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.dto.CalendarEventDto;
import app.dto.TeacherOnRealizationDto;
import app.entities.TeacherOnRealization;

@Component
public class TeacherOnRealizationMapper implements Mapper<TeacherOnRealization, TeacherOnRealizationDto> {
	
	@Autowired
	TeacherMapper teacherMapper;
	
	@Autowired
	TeachingTypeMapper teacherTypeMapper;
	
	public TeacherOnRealizationDto toDTO(TeacherOnRealization teacherOnRealization) {
		TeacherOnRealizationDto retVal = new TeacherOnRealizationDto();
			retVal.setId(teacherOnRealization.getId());
			retVal.setNumberOfClasses(teacherOnRealization.getNumberOfClasses());
			retVal.setVersion(teacherOnRealization.getVersion());
			retVal.setTeacherDto(teacherMapper.toDTO(teacherOnRealization.getTeacher()));
			retVal.setTeachingTypeDto(teacherTypeMapper.toDTO(teacherOnRealization.getTeachingType()));
			return retVal;

	}
	
	public TeacherOnRealization toEntity(TeacherOnRealizationDto teacherOnRealizationDto) {
		return null;		
	}
	
	public List<TeacherOnRealizationDto> toDTO(List<TeacherOnRealization> teacherOnRealization){
		List<TeacherOnRealizationDto > retVal = new ArrayList<TeacherOnRealizationDto >();
		for (TeacherOnRealization teacherOnRealizations: teacherOnRealization) {
			retVal.add(toDTO(teacherOnRealizations));
		}
		return retVal;
	}

	public List<TeacherOnRealization> toEntity(List<TeacherOnRealizationDto > teacherOnRealizationDto){
		return null;
	}



}
