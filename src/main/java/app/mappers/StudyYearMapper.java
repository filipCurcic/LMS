package app.mappers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import app.dto.StudyYearDto;
import app.entities.StudentOnYear;
import app.entities.StudyCourse;
import app.entities.StudyYear;

@Component
public class StudyYearMapper implements Mapper<StudyYear, StudyYearDto> {

	public StudyYearDto toDTO(StudyYear studyYear) {
		
		if(studyYear == null) {
			return null;
		}
		
		StudyYearDto retVal = new StudyYearDto();
			retVal.setId(studyYear.getId());
			retVal.setYear(studyYear.getYear());
			retVal.setStudyYear(studyYear.getStudyYear());
			retVal.setStudentOnYear(new ArrayList<>());
			for(StudentOnYear studentOnYear: studyYear.getStudentsOnYear()) {
				retVal.getStudentOnYear().add("/student-on-year/" + studentOnYear.getId());
			}
			retVal.setStudyCourse(new ArrayList<>());
			for(StudyCourse studyCourse: studyYear.getStudyCoures()) {
				retVal.getStudyCourse().add("/study-course/" + studyCourse.getId());
			}
			return retVal;

	}
	
	public StudyYear toEntity(StudyYearDto studyYearDto) {
		if(studyYearDto == null) {
			return null;		
		}
		
		StudyYear studyYear = new StudyYear();
		
		studyYear.setId(studyYearDto.getId());
		studyYear.setYear(studyYearDto.getYear());
		studyYear.setStudyYear(studyYearDto.getStudyYear());
		
		return studyYear;
	}
	
	public List<StudyYearDto> toDTO(List<StudyYear> studyYear){
		
		if(studyYear == null) {
			return null;
		}
		
		List<StudyYearDto > retVal = new ArrayList<StudyYearDto >();
		for (StudyYear studyYears: studyYear) {
			retVal.add(toDTO(studyYears));
		}
		return retVal;
	}

	public Collection<StudyYear> toEntity(Collection<StudyYearDto > studyYearDto){
		if(studyYearDto == null) {
			return null;
		}
		
		Collection<StudyYear> studyYear = new ArrayList<StudyYear>(studyYearDto.size());
		for(StudyYearDto sDto: studyYearDto) {
			studyYear.add(toEntity(sDto));
		}
		
		return studyYear;
	}

}
