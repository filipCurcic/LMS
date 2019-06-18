package app.mappers;

import java.util.ArrayList;
import java.util.Collection;
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
		
		if(studyCourse == null) {
			return null;
		}
		
		StudyCourseDto retVal = new StudyCourseDto();
			retVal.setId(studyCourse.getId());
			retVal.setName(studyCourse.getName());
			retVal.setVersion(studyCourse.getVersion());
			retVal.setFaculty(facultyMapper.toDTO(studyCourse.getFaculty()));
			retVal.setStudyCourseTeacher(new ArrayList<>());
			for (StudyCourseTeacher studyCourseTeacher: studyCourse.getStudyCourseTeacher()) {
				retVal.getStudyCourseTeacher().add("/study-course-teacher/"+studyCourseTeacher.getId());
			}
			return retVal;

	}
	
	public StudyCourse toEntity(StudyCourseDto studyCourseDto) {
		if(studyCourseDto == null) {
			return null;		
		}
		
		StudyCourse studyCourse = new StudyCourse();
		
		studyCourse.setId(studyCourseDto.getId());
		studyCourse.setName(studyCourseDto.getName());
		studyCourse.setVersion(studyCourseDto.getVersion());
		studyCourse.setFaculty(facultyMapper.toEntity(studyCourseDto.getFaculty()));
		return studyCourse;
	}
	
	public List<StudyCourseDto> toDTO(List<StudyCourse> studyCourse){
		
		if(studyCourse == null) {
			return null;
		}
		
		List<StudyCourseDto > retVal = new ArrayList<StudyCourseDto >();
		for (StudyCourse studyCourses: studyCourse) {
			retVal.add(toDTO(studyCourses));
		}
		return retVal;
	}

	public Collection<StudyCourse> toEntity(Collection<StudyCourseDto > studyCourseDto){
		if(studyCourseDto == null) {
			return null;
		}
		
		Collection<StudyCourse> studyCourse = new ArrayList<StudyCourse>(studyCourseDto.size());
		for(StudyCourseDto sDto: studyCourseDto) {
			studyCourse.add(toEntity(sDto));
		}
		
		return studyCourse;
	}

	
}
