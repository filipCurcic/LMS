package app.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.dto.CourseDto;
import app.dto.CourseOutcomeDto;
import app.entities.CourseOutcome;

@Component
public class CourseOutcomeMapper implements Mapper<CourseOutcome, CourseOutcomeDto> {

	@Autowired
	CourseMapper courseMapper;
	
	public CourseOutcomeDto toDTO(CourseOutcome courseOutcome) {
		CourseOutcomeDto retVal = new CourseOutcomeDto();
			retVal.setId(courseOutcome.getId());
			retVal.setDescription(courseOutcome.getDescription());
			retVal.setCourseDto(new CourseDto());
			retVal.setCourseDto(courseMapper.toDTO(courseOutcome.getCourse()));
			return retVal;

	}
	
	public CourseOutcome toEntity(CourseOutcomeDto courseOutcomeDto) {
		return null;		
	}
	
	public List<CourseOutcomeDto> toDTO(List<CourseOutcome> courseOutcome){
		List<CourseOutcomeDto > retVal = new ArrayList<CourseOutcomeDto >();
		for (CourseOutcome courseOutcomes: courseOutcome) {
			retVal.add(toDTO(courseOutcomes));
		}
		return retVal;
	}

	public List<CourseOutcome> toEntity(List<CourseOutcomeDto > courseOutcomeDto){
		return null;
	}

}
