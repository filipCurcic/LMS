package app.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import app.dto.StudyYearDto;
import app.entities.StudentOnYear;
import app.entities.StudyCourse;
import app.entities.StudyYear;

@Component
public class StudyYearMapper implements Mapper<StudyYear, StudyYearDto> {

	public StudyYearDto toDTO(StudyYear studyYear) {
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
		return null;		
	}
	
	public List<StudyYearDto> toDTO(List<StudyYear> studyYear){
		List<StudyYearDto > retVal = new ArrayList<StudyYearDto >();
		for (StudyYear studyYears: studyYear) {
			retVal.add(toDTO(studyYears));
		}
		return retVal;
	}

	public List<StudyYear> toEntity(List<StudyYearDto > studyYearDto){
		return null;
	}

}
