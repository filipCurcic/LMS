package app.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.dto.StudentDto;
import app.dto.StudentOnYearDto;
import app.entities.StudentOnYear;

@Component
public class StudentOnYearMapper implements Mapper<StudentOnYear, StudentOnYearDto> {
	
	@Autowired
	StudentMapper studentMapper;
	
	@Autowired
	StudyYearMapper studyYearMapper;

	public StudentOnYearDto toDTO(StudentOnYear studentOnYear) {
		StudentOnYearDto retVal = new StudentOnYearDto();
			retVal.setId(studentOnYear.getId());
			retVal.setIndeks(studentOnYear.geIndeks());
			retVal.setEnrollmentDate(studentOnYear.getEnrollmentDate());
			retVal.setStudentDto(new StudentDto());
			retVal.setStudentDto(studentMapper.toDTO(studentOnYear.getStudent()));
			retVal.setStudyYearDto(studyYearMapper.toDTO(studentOnYear.getStudyYear()));
			return retVal;

	}
	
	public StudentOnYear toEntity(StudentOnYearDto studentOnYearDto) {
		return null;		
	}
	
	public List<StudentOnYearDto> toDTO(List<StudentOnYear> studentOnYear){
		List<StudentOnYearDto > retVal = new ArrayList<StudentOnYearDto >();
		for (StudentOnYear studentOnYears: studentOnYear) {
			retVal.add(toDTO(studentOnYears));
		}
		return retVal;
	}

	public List<StudentOnYear> toEntity(List<StudentOnYearDto > studentOnYearDto){
		return null;
	}

	
}
