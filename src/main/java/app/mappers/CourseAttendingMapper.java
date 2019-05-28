package app.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.dto.CourseAttendingDto;
import app.dto.CourseRealizationDto;
import app.dto.StudentDto;
import app.entities.CourseAttending;
import app.entities.CourseRealization;

@Component
public class CourseAttendingMapper implements Mapper<CourseAttending, CourseAttendingDto>{

	@Autowired
	StudentMapper studentMapper;
	
	@Autowired
	CourseRealizationMapper courseRealizationMapper;
	
	public CourseAttendingDto toDTO(CourseAttending courseAttending) {
		CourseAttendingDto retVal = new CourseAttendingDto();
			retVal.setId(courseAttending.getId());
			retVal.setStudent(new StudentDto());
			retVal.setStudent(studentMapper.toDTO(courseAttending.getStudent()));
			retVal.setCourseRealization(new CourseRealizationDto());
			retVal.setCourseRealization(courseRealizationMapper.toDTO(courseAttending.getCourseRealization()));
			return retVal;

	}
	
	public CourseAttending toEntity(CourseAttendingDto courseAttendingDto) {
		return null;		
	}
	
	public List<CourseAttendingDto> toDTO(List<CourseAttending> courseAttending){
		List<CourseAttendingDto > retVal = new ArrayList<CourseAttendingDto >();
		for (CourseAttending courseAttendings: courseAttending) {
			retVal.add(toDTO(courseAttendings));
		}
		return retVal;
	}

	public List<CourseAttending> toEntity(List<CourseAttendingDto > courseAttendingDto){
		return null;
	}

}
