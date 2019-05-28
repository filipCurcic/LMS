package app.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.dto.FacultyDto;
import app.dto.StudyCourseDto;
import app.dto.StudyCourseTeacherDto;
import app.dto.TeacherDto;
import app.entities.StudyCourse;
import app.entities.StudyCourseTeacher;

@Component
public class StudyCourseTeacherMapper implements Mapper<StudyCourseTeacher, StudyCourseTeacherDto> {

	@Autowired
	StudyCoureseMapper studyCourseMapper;
	
	@Autowired
	TeacherMapper teacherMapper;
	

	public StudyCourseTeacherDto toDTO(StudyCourseTeacher studyCourseTeacher) {
		StudyCourseTeacherDto retVal = new StudyCourseTeacherDto();
			retVal.setId(studyCourseTeacher.getId());
			retVal.setStudyCourseDto(new StudyCourseDto());
			retVal.setStudyCourseDto(studyCourseMapper.toDTO(studyCourseTeacher.getStudyCourse()));
			retVal.setTeacherDto(new TeacherDto());
			retVal.setTeacherDto(teacherMapper.toDTO(studyCourseTeacher.getTeacher()));
			return retVal;

	}
	
	public StudyCourseTeacher toEntity(StudyCourseTeacherDto studyCourseTeacherDto) {
		return null;		
	}
	
	public List<StudyCourseTeacherDto> toDTO(List<StudyCourseTeacher> studyCourseTeacher){
		List<StudyCourseTeacherDto > retVal = new ArrayList<StudyCourseTeacherDto >();
		for (StudyCourseTeacher studyCourseTeachers: studyCourseTeacher) {
			retVal.add(toDTO(studyCourseTeachers));
		}
		return retVal;
	}

	public List<StudyCourseTeacher> toEntity(List<StudyCourseTeacherDto > studyCourseTeacherDto){
		return null;
	}



}

