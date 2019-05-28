package app.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.dto.FacultyDto;
import app.dto.StudyCourseDto;
import app.entities.StudyCourse;
import app.entities.StudyCourseTeacher;

@Component
public class StudyCoureseMapper implements Mapper<StudyCourse, StudyCourseDto> {
	
	@Autowired
	FacultyMapper facultyMapper;

	public StudyCourseDto toDTO(StudyCourse studyCourse) {
		StudyCourseDto retVal = new StudyCourseDto();
			retVal.setId(studyCourse.getId());
			retVal.setName(studyCourse.getName());
			retVal.setVersion(studyCourse.getVersion());
			retVal.setFacultyDto(new FacultyDto());
			retVal.setFacultyDto(facultyMapper.toDTO(studyCourse.getFaculty()));
			retVal.setStudyCourseTeacher(new ArrayList<>());
			for (StudyCourseTeacher studyCourseTeacher: studyCourse.getStudyCourseTeacher()) {
				retVal.getStudyCourseTeacher().add("/study-course-teacher/"+studyCourseTeacher.getId());
			}
			return retVal;

	}
	
	public StudyCourse toEntity(StudyCourseDto studyCourseDto) {
		return null;		
	}
	
	public List<StudyCourseDto> toDTO(List<StudyCourse> studyCourse){
		List<StudyCourseDto > retVal = new ArrayList<StudyCourseDto >();
		for (StudyCourse studyCourses: studyCourse) {
			retVal.add(toDTO(studyCourses));
		}
		return retVal;
	}

	public List<StudyCourse> toEntity(List<StudyCourseDto > studyCourseDto){
		return null;
	}

	
}
