package app.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import app.dto.FacultyDto;
import app.entities.Faculty;
import app.entities.StudyCourse;
import app.entities.Teacher;

@Component
public class FacultyMapper implements Mapper<Faculty, FacultyDto> {

	
	public FacultyDto toDTO(Faculty faculty) {
		FacultyDto retVal = new FacultyDto();
			retVal.setId(faculty.getId());
			retVal.setName(faculty.getName());
			retVal.setDescription(faculty.getDescription());
			retVal.setContact(faculty.getContact());
			retVal.setEmail(faculty.getEmail());
			retVal.setTeachers(new ArrayList());
			for(Teacher teacher: faculty.getTeachers()) {
				retVal.getTeachers().add("/teacher/" + teacher.getId());
			}
			retVal.setStudyCourse(new ArrayList<>());
			for(StudyCourse studyCourse: faculty.getStudyCourse()) {
				retVal.getStudyCourse().add("study-course/" + studyCourse.getId());
			}
			//retVal.setStudyCourse(studyCourse);
			return retVal;

	}
	
	public Faculty toEntity(FacultyDto facultyDto) {
		return null;		
	}
	
	public List<FacultyDto> toDTO(List<Faculty> faculty){
		List<FacultyDto > retVal = new ArrayList<FacultyDto >();
		for (Faculty faculties: faculty) {
			retVal.add(toDTO(faculties));
		}
		return retVal;
	}

	public List<Faculty> toEntity(List<FacultyDto > facultyDto){
		return null;
	}

}
