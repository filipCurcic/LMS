package app.mappers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.dto.CourseDto;
import app.dto.CourseRealizationDto;
import app.dto.TeacherOnRealizationDto;
import app.entities.CourseAttending;
import app.entities.CourseRealization;

@Component
public class CourseRealizationMapper implements Mapper<CourseRealization, CourseRealizationDto> {

	@Autowired
	CourseMapper courseMapper;
	
	@Autowired
	TeacherOnRealizationMapper teacherOnRealizationMapper;
	
	public CourseRealizationDto toDTO(CourseRealization courseRealization) {
		
		if(courseRealization == null) {
			return null;
		}
		
		CourseRealizationDto retVal = new CourseRealizationDto();
			retVal.setId(courseRealization.getId());
			retVal.setStartDate(courseRealization.getStartDate());
			retVal.setEndDate(courseRealization.getEndDate());
			retVal.setCourseDto(new CourseDto());
			retVal.setCourseDto(courseMapper.toDTO(courseRealization.getCourse()));
			retVal.setTeacherOnRealizationDto(new TeacherOnRealizationDto());
			retVal.setTeacherOnRealizationDto(teacherOnRealizationMapper.toDTO(courseRealization.getTeacherOnRealization()));
			retVal.setCourseAttendings(new ArrayList<>());
			for (CourseAttending courseAttending: courseRealization.getCourseAttendings()) {
				retVal.getCourseAttendings().add("/course-attending/"+ courseRealization.getId());
			}
			return retVal;

	}
	
	public CourseRealization toEntity(CourseRealizationDto courseRealizationDto) {
		if(courseRealizationDto == null) {
			return null;		
		}
		
		CourseRealization courseRealization = new CourseRealization();
		
		courseRealization.setId(courseRealizationDto.getId());
		courseRealization.setStartDate(courseRealizationDto.getStartDate());
		courseRealization.setEndDate(courseRealizationDto.getEndDate());
		courseRealization.setTeacherOnRealization(teacherOnRealizationMapper.toEntity(courseRealizationDto.getTeacherOnRealizationDto()));
		courseRealization.setCourse(courseMapper.toEntity(courseRealizationDto.getCourseDto()));
		return courseRealization;
	}
	
	public List<CourseRealizationDto> toDTO(List<CourseRealization> courseRealization){
		
		if(courseRealization == null) {
			return null;
		}
		
		List<CourseRealizationDto > retVal = new ArrayList<CourseRealizationDto >();
		for (CourseRealization courseRealizations: courseRealization) {
			retVal.add(toDTO(courseRealizations));
		}
		return retVal;
	}

	public Collection<CourseRealization> toEntity(Collection<CourseRealizationDto > courseRealizationDto){
		if(courseRealizationDto == null) {
			return null;
		}
		
		Collection<CourseRealization> courseRealization = new ArrayList<CourseRealization>(courseRealizationDto.size());
		for(CourseRealizationDto cDto: courseRealizationDto) {
			courseRealization.add(toEntity(cDto));
		}
		
		return courseRealization;
	}

}
