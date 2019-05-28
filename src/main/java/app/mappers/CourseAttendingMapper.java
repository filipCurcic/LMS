package app.mappers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.dto.CourseAttendingDto;
import app.dto.CourseRealizationDto;
import app.dto.StudentDto;
import app.entities.CourseAttending;

@Component
public class CourseAttendingMapper implements Mapper<CourseAttending, CourseAttendingDto>{

	@Autowired
	StudentMapper studentMapper;
	
	@Autowired
	CourseRealizationMapper courseRealizationMapper;
	
	public CourseAttendingDto toDTO(CourseAttending courseAttending) {
		
		if(courseAttending == null) {
			return null;
		}
		
		CourseAttendingDto retVal = new CourseAttendingDto();
			retVal.setId(courseAttending.getId());
			retVal.setStudent(new StudentDto());
			retVal.setStudent(studentMapper.toDTO(courseAttending.getStudent()));
			retVal.setCourseRealization(new CourseRealizationDto());
			retVal.setCourseRealization(courseRealizationMapper.toDTO(courseAttending.getCourseRealization()));
			return retVal;

	}
	
	public CourseAttending toEntity(CourseAttendingDto courseAttendingDto) {
		if(courseAttendingDto == null) {
			return null;		
		}
		
		CourseAttending courseAttending = new CourseAttending();
		
		courseAttending.setId(courseAttendingDto.getId());
		courseAttending.setStudent(studentMapper.toEntity(courseAttendingDto.getStudent()));
		courseAttending.setCourseRealization(courseRealizationMapper.toEntity(courseAttendingDto.getCourseRealization()));
		return courseAttending;
	}
	
	public List<CourseAttendingDto> toDTO(List<CourseAttending> courseAttending){
		
		if(courseAttending == null) {
			return null;
		}
		
		List<CourseAttendingDto > retVal = new ArrayList<CourseAttendingDto >();
		for (CourseAttending courseAttendings: courseAttending) {
			retVal.add(toDTO(courseAttendings));
		}
		return retVal;
	}

	public Collection<CourseAttending> toEntity(Collection<CourseAttendingDto > courseAttendingDto){
		if(courseAttendingDto == null) {
			return null;
		}
		
		Collection<CourseAttending> courseAttending = new ArrayList<CourseAttending>(courseAttendingDto.size());
		for(CourseAttendingDto cDto: courseAttendingDto) {
			courseAttending.add(toEntity(cDto));
		}
		
		return courseAttending;
	}

}
