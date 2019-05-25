package app.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import app.dto.StudentDto;
import app.entities.City;
import app.entities.Student;

@Component
public class StudentMapper implements Mapper<Student, StudentDto> {
	

	public StudentDto toDTO(Student student) {
		StudentDto retVal = new StudentDto();
			retVal.setId(student.getId());
			retVal.setName(student.getName());
			retVal.setLastName(student.getLastName());
			retVal.setJmbg(student.getJmbg());
			retVal.setProfilePicturePath(student.getProfilePicturePath());
		/*	retVal.setCity(new ArrayList<>());
			for (City city: country.getCity()) {
				retVal.getCity().add("/city/"+city.getId());
			}*/
			//retVal.setCity(CityMapper.toDTO(country.g));
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
