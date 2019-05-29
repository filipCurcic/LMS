package app.mappers;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Collection;
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
		
		if(studentOnYear == null) {
			return null;
		}
		
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
		if(studentOnYearDto == null) {
			return null;		
		}
		
		StudentOnYear studentOnYear = new StudentOnYear();
		
		studentOnYear.setId(studentOnYearDto.getId());
		studentOnYear.setEnrollmentDate(studentOnYearDto.getEnrollmentDate());
		studentOnYear.setIndeks(studentOnYearDto.getIndeks());
		studentOnYear.setStudent(studentMapper.toEntity(studentOnYearDto.getStudentDto()));
		studentOnYear.setStudyYear(studyYearMapper.toEntity(studentOnYearDto.getStudyYearDto()));
		return studentOnYear;
	}
	
	public List<StudentOnYearDto> toDTO(List<StudentOnYear> studentOnYear){
		
		if(studentOnYear == null) {
			return null;
		}
		
		List<StudentOnYearDto > retVal = new ArrayList<StudentOnYearDto >();
		for (StudentOnYear studentOnYears: studentOnYear) {
			retVal.add(toDTO(studentOnYears));
		}
		return retVal;
	}

	public Collection<StudentOnYear> toEntity(Collection<StudentOnYearDto > studentOnYearDto){
		if(studentOnYearDto == null) {
			return null;
		}
		
		Collection<StudentOnYear> studentOnYear = new ArrayList<StudentOnYear>(studentOnYearDto.size());
		for(StudentOnYearDto sDto: studentOnYearDto) {
			studentOnYear.add(toEntity(sDto));
		}
		
		return studentOnYear;
	}

	
}
