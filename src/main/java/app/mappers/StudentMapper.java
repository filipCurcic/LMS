package app.mappers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.dto.RegisteredUserDto;
import app.dto.StudentDto;
import app.entities.Student;
import app.entities.StudentOnYear;

@Component
public class StudentMapper implements Mapper<Student, StudentDto> {

	@Autowired
	RegisteredUserMapper registeredUserMapper;
	
	@Autowired
	AddressMapper addressMapper;

	public StudentDto toDTO(Student student) {
		
		if(student == null) {
			return null;
		}
		
		StudentDto retVal = new StudentDto();
			retVal.setId(student.getId());
			retVal.setName(student.getName());
			retVal.setLastName(student.getLastName());
			retVal.setJmbg(student.getJmbg());
			retVal.setProfilePicturePath(student.getProfilePicturePath());
			retVal.setRegisteredUserDto(new RegisteredUserDto());
			retVal.setRegisteredUserDto(registeredUserMapper.toDTO(student.getRegisteredUser()));
			retVal.setAddressDto(addressMapper.toDTO(student.getAddress()));
			retVal.setStudentYear(new ArrayList<>());
			for(StudentOnYear studentOnYear: student.getStudentYears()) {
				retVal.getStudentYear().add("/address/" + studentOnYear.getId());
			}
		return retVal;

	}
	
	public Student toEntity(StudentDto studentDto) {
		if(studentDto == null) {
			return null;		
		}
		
		Student student = new Student();
		
		student.setId(studentDto.getId());
		student.setAddress(addressMapper.toEntity(studentDto.getAddressDto()));
		student.setJmbg(studentDto.getJmbg());
		student.setName(studentDto.getName());
		student.setLastName(studentDto.getLastName());
		student.setProfilePicturePath(studentDto.getProfilePicturePath());
		student.setRegisteredUser(registeredUserMapper.toEntity(studentDto.getRegisteredUserDto()));
		return student;
	}
	
	public List<StudentDto> toDTO(List<Student> student){
		
		if(student == null) {
			return null;
		}
		
		List<StudentDto > retVal = new ArrayList<StudentDto >();
		for (Student students: student) {
			retVal.add(toDTO(students));
		}
		return retVal;
	}

	public Collection<Student> toEntity(Collection<StudentDto > studentDto){
		if(studentDto == null) {
			return null;
		}
		
		Collection<Student> student = new ArrayList<Student>(studentDto.size());
		for(StudentDto sDto: studentDto) {
			student.add(toEntity(sDto));
		}
		
		return student;
	}


}
