package app.mappers;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.dto.CountryDto;
import app.dto.CourseDto;
import app.dto.CourseRealizationDto;
import app.dto.TeacherOnRealizationDto;
import app.entities.City;
import app.entities.Country;
import app.entities.CourseAttending;
import app.entities.CourseRealization;

@Component
public class CourseRealizationMapper implements Mapper<CourseRealization, CourseRealizationDto> {

	@Autowired
	CourseMapper courseMapper;
	
	@Autowired
	TeacherOnRealizationMapper teacherOnRealizationMapper;
	
	public CourseRealizationDto toDTO(CourseRealization courseRealization) {
		CourseRealizationDto retVal = new CourseRealizationDto();
			retVal.setId(courseRealization.getId());
			retVal.setStartDate(courseRealization.getStartDate());
			retVal.setEndDate(courseRealization.getEndDate());
			retVal.setCourseDto(new CourseDto());
			retVal.setCourseDto(courseMapper.toDTO(courseRealization.getCourse()));
			retVal.setTeacherOnRealizationDto(new TeacherOnRealizationDto());
			//retVal.setTeacherOnRealizationDto(teacherOnRealizationMapper.toDTO(courseRealization.getTeacherOnRealization()));
//			retVal.setCourseAttendings(new ArrayList<>());
//			for (CourseAttending courseAttending: courseRealization.getCourseAttendings()) {
//				retVal.getCourseAttendings().add("/course-attending/"+ courseRealization.getId());
//			}
			return retVal;

	}
	
	public CourseRealization toEntity(CourseRealizationDto courseRealizationDto) {
		return null;		
	}
	
	public List<CourseRealizationDto> toDTO(List<CourseRealization> courseRealization){
		List<CourseRealizationDto > retVal = new ArrayList<CourseRealizationDto >();
		for (CourseRealization courseRealizations: courseRealization) {
			retVal.add(toDTO(courseRealizations));
		}
		return retVal;
	}

	public List<CourseRealization> toEntity(List<CourseRealizationDto > courseRealizationDto){
		return null;
	}

}
