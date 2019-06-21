package app.mappers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.tika.utils.RereadableInputStream;
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
		
		if(teacher == null) {
			return null;
		}
		
		TeacherDto retVal = new TeacherDto();
			retVal.setId(teacher.getId());
			retVal.setName(teacher.getName());
			retVal.setLastName(teacher.getLastName());
			retVal.setBiography(teacher.getBiography());
			retVal.setProfilePicturePath(teacher.getProfilePicturePath());
			retVal.setUmcn(teacher.getUmcn());
			retVal.setAddress(addressMapper.toDTO(teacher.getAddress()));
			retVal.setUniversity(universityMapper.toDTO(teacher.getUniversity()));
			retVal.setFaculty(facultyMaper.toDTO(teacher.getFaculty()));
			retVal.setRegisteredUser(registeredUserMapper.toDTO(teacher.getRegisteredUser()));
			
			return retVal;

	}
	
	public Teacher toEntity(TeacherDto teacherDto) {
		if(teacherDto == null) {
			return null;		
		}
		
		Teacher teacher = new Teacher();
		
		teacher.setId(teacherDto.getId());
		teacher.setAddress(addressMapper.toEntity(teacherDto.getAddress()));
		teacher.setBiography(teacherDto.getBiography());
		teacher.setName(teacherDto.getName());
		teacher.setLastName(teacherDto.getLastName());
		teacher.setProfilePicturePath(teacherDto.getProfilePicturePath());
		teacher.setUmcn(teacherDto.getUmcn());
		teacher.setUniversity(universityMapper.toEntity(teacherDto.getUniversity()));
		teacher.setRegisteredUser(registeredUserMapper.toEntity(teacherDto.getRegisteredUser()));
		teacher.setFaculty(facultyMaper.toEntity(teacherDto.getFaculty()));
		return teacher;
	}
	
	public List<TeacherDto> toDTO(List<Teacher> teacher){
		
		if(teacher == null) {
			return null;
		}
		
		List<TeacherDto > retVal = new ArrayList<TeacherDto >();
		for (Teacher teachers: teacher) {
			retVal.add(toDTO(teachers));
		}
		return retVal;
	}

	public Collection<Teacher> toEntity(Collection<TeacherDto > teacherDto){
		if(teacherDto == null) {
			return null;
		}
		
		Collection<Teacher> teacher = new ArrayList<Teacher>(teacherDto.size());
		for( TeacherDto tDto: teacherDto) {
			teacher.add(toEntity(tDto));
		}
		
		return teacher;
	}



}
