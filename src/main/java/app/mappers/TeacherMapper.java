package app.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.dto.TeacherDto;
import app.entities.StudyCourseTeacher;
import app.entities.Teacher;
import app.entities.TeacherOnRealization;
import app.entities.Title;

@Component
public class TeacherMapper implements Mapper<Teacher, TeacherDto> {
	
	@Autowired
	StudyCourseTeacherMapper studyCourseTeacherMapper;
	
	@Autowired
	UniversityMapper universityMapper;
	
	@Autowired
	FacultyMapper facultyMaper;
	
	@Autowired
	RegisteredUserMapper registeredUserMapper;
	
	@Autowired
	AddressMapper addressMapper;
	
	public TeacherDto toDTO(Teacher teacher) {
		TeacherDto retVal = new TeacherDto();
			retVal.setId(teacher.getId());
			retVal.setName(teacher.getName());
			retVal.setLastName(teacher.getLastName());
			retVal.setBiography(teacher.getBiography());
			retVal.setProfilePicturePath(teacher.getProfilePicturePath());
			retVal.setUmcn(teacher.getUmcn());
			retVal.setAddressDto(addressMapper.toDTO(teacher.getAddress()));
			retVal.setUniversityDto(universityMapper.toDTO(teacher.getUniversity()));
			retVal.setFacultyDto(facultyMaper.toDTO(teacher.getFaculty()));
			retVal.setRegisteredUserDto(registeredUserMapper.toDTO(teacher.getRegisteredUser()));
			retVal.setTeachersOnRealization(new ArrayList<>());
			for (TeacherOnRealization teacherOnRealization: teacher.getTeachersOnRealization()) {
				retVal.getTeachersOnRealization().add("/teacher-on-realization/"+ teacherOnRealization.getId());
			}
			retVal.setStudyCourseTeacher(new ArrayList<>());
			for(StudyCourseTeacher studyCourseTeacher: teacher.getStudyCourseTeacher()) {
				retVal.getStudyCourseTeacher().add("/study-course-teacher/" + studyCourseTeacher.getId());
			}
			retVal.setTitles(new ArrayList<>());
			for (Title title: teacher.getTitles()) {
				retVal.getTitles().add("/title/" + title.getId());
			}
			return retVal;

	}
	
	public Teacher toEntity(TeacherDto teacherDto) {
		return null;		
	}
	
	public List<TeacherDto> toDTO(List<Teacher> teacher){
		List<TeacherDto > retVal = new ArrayList<TeacherDto >();
		for (Teacher teachers: teacher) {
			retVal.add(toDTO(teachers));
		}
		return retVal;
	}

	public List<Teacher> toEntity(List<TeacherDto > teacherDto){
		return null;
	}



}
