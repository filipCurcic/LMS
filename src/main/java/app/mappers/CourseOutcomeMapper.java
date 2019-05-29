package app.mappers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.dto.CourseDto;
import app.dto.CourseOutcomeDto;
import app.entities.Course;
import app.entities.CourseOutcome;

@Component
public class CourseOutcomeMapper implements Mapper<CourseOutcome, CourseOutcomeDto> {

	@Autowired
	CourseMapper courseMapper;
	
	public CourseOutcomeDto toDTO(CourseOutcome courseOutcome) {
		
		if(courseOutcome == null) {
			return null;
		}
		
		CourseOutcomeDto retVal = new CourseOutcomeDto();
			retVal.setId(courseOutcome.getId());
			retVal.setDescription(courseOutcome.getDescription());
			retVal.setCourseDto(new CourseDto());
			retVal.setCourseDto(courseMapper.toDTO(courseOutcome.getCourse()));
			return retVal;

	}
	
	public CourseOutcome toEntity(CourseOutcomeDto courseOutcomeDto) {
		if(courseOutcomeDto == null) {
			return null;		
		}
		
		CourseOutcome courseOutcome = new CourseOutcome();
		
		courseOutcome.setId(courseOutcomeDto.getId());
		courseOutcome.setDescription(courseOutcomeDto.getDescription());
		courseOutcome.setCourse(courseMapper.toEntity(courseOutcomeDto.getCourseDto()));
		return courseOutcome;
	}
	
	public List<CourseOutcomeDto> toDTO(List<CourseOutcome> courseOutcome){
		
		if(courseOutcome == null) {
			return null;
		}
		
		List<CourseOutcomeDto > retVal = new ArrayList<CourseOutcomeDto >();
		for (CourseOutcome courseOutcomes: courseOutcome) {
			retVal.add(toDTO(courseOutcomes));
		}
		return retVal;
	}

	public Collection<CourseOutcome> toEntity(Collection<CourseOutcomeDto > courseOutcomeDto){
		if(courseOutcomeDto == null) {
			return null;
		}
		
		Collection<CourseOutcome> courseOutcome = new ArrayList<CourseOutcome>(courseOutcomeDto.size());
		for(CourseOutcomeDto cDto: courseOutcomeDto) {
			courseOutcome.add(toEntity(cDto));
		}
		
		return courseOutcome;
	}

}
