package app.mappers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.dto.StudyCourseDto;
import app.dto.StudyCourseTeacherDto;
import app.dto.TeacherDto;
import app.entities.StudyCourseTeacher;

@Component
public class StudyCourseTeacherMapper implements Mapper<StudyCourseTeacher, StudyCourseTeacherDto> {

	@Autowired
	StudyCoureseMapper studyCourseMapper;
	
	@Autowired
	TeacherMapper teacherMapper;
	

	public StudyCourseTeacherDto toDTO(StudyCourseTeacher studyCourseTeacher) {
		
		if(studyCourseTeacher == null) {
			return null;
		}
		
		StudyCourseTeacherDto retVal = new StudyCourseTeacherDto();
			retVal.setId(studyCourseTeacher.getId());
			retVal.setStudyCourseDto(new StudyCourseDto());
			retVal.setStudyCourseDto(studyCourseMapper.toDTO(studyCourseTeacher.getStudyCourse()));
			retVal.setTeacherDto(new TeacherDto());
			retVal.setTeacherDto(teacherMapper.toDTO(studyCourseTeacher.getTeacher()));
			return retVal;

	}
	
	public StudyCourseTeacher toEntity(StudyCourseTeacherDto studyCourseTeacherDto) {
		if(studyCourseTeacherDto == null) {
			return null;		
		}
		
		StudyCourseTeacher studyCourseTeacher = new StudyCourseTeacher();
		
		studyCourseTeacher.setId(studyCourseTeacherDto.getId());
		studyCourseTeacher.setStudyCourse(studyCourseMapper.toEntity(studyCourseTeacherDto.getStudyCourseDto()));
		studyCourseTeacher.setTeacher(teacherMapper.toEntity(studyCourseTeacherDto.getTeacherDto()));
		
		return studyCourseTeacher;
	}
	
	public List<StudyCourseTeacherDto> toDTO(List<StudyCourseTeacher> studyCourseTeacher){
		
		if(studyCourseTeacher == null) {
			return null;
		}
		
		List<StudyCourseTeacherDto > retVal = new ArrayList<StudyCourseTeacherDto >();
		for (StudyCourseTeacher studyCourseTeachers: studyCourseTeacher) {
			retVal.add(toDTO(studyCourseTeachers));
		}
		return retVal;
	}

	public Collection<StudyCourseTeacher> toEntity(Collection<StudyCourseTeacherDto > studyCourseTeacherDto){
		if(studyCourseTeacherDto == null) {
			return null;
		}
		
		Collection<StudyCourseTeacher> studyCourseTeacher = new ArrayList<StudyCourseTeacher>(studyCourseTeacherDto.size());
		for(StudyCourseTeacherDto sDto: studyCourseTeacherDto) {
			studyCourseTeacher.add(toEntity(sDto));
		}
		
		return studyCourseTeacher;
	}



}

