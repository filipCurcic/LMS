package app.mappers;

import java.util.ArrayList;
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
		return null;		
	}
	
	public List<StudentDto> toDTO(List<Student> student){
		List<StudentDto > retVal = new ArrayList<StudentDto >();
		for (Student students: student) {
			retVal.add(toDTO(students));
		}
		return retVal;
	}

	public List<Student> toEntity(List<StudentDto > studentDto){
		// TODO implementirati logiku konverzije
		return null;
	}


}
