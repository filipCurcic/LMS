package app.mappers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.dto.StudyYearDto;
import app.entities.StudentOnYear;
import app.entities.StudyCourse;
import app.entities.StudyYear;

@Component
public class StudyYearMapper implements Mapper<StudyYear, StudyYearDto> {

	@Autowired
	StudyCoureseMapper studyCourseMapper;
	public StudyYearDto toDTO(StudyYear studyYear) {
		
		if(studyYear == null) {
			return null;
		}
		
		StudyYearDto retVal = new StudyYearDto();
			retVal.setId(studyYear.getId());
			retVal.setStartDate(studyYear.getStartDate());
			retVal.setEndDate(studyYear.getEndDate());
			retVal.setStudyYear(studyYear.getStudyYear());
			retVal.setStudentOnYear(new ArrayList<>());
			for(StudentOnYear studentOnYear: studyYear.getStudentsOnYear()) {
				retVal.getStudentOnYear().add("/student-on-year/" + studentOnYear.getId());
			}
			retVal.setStudyCourse(studyCourseMapper.toDTO(studyYear.getStudyCourse()));
			return retVal;

	}
	
	public StudyYear toEntity(StudyYearDto studyYearDto) {
		if(studyYearDto == null) {
			return null;		
		}
		
		StudyYear studyYear = new StudyYear();
		
		studyYear.setId(studyYearDto.getId());
		studyYear.setStartDate(studyYearDto.getStartDate());
		studyYear.setEndDate(studyYearDto.getEndDate());
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
