package app.mappers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.dto.FacultyDto;
import app.entities.Faculty;
import app.entities.StudyCourse;
import app.entities.Teacher;

@Component
public class FacultyMapper implements Mapper<Faculty, FacultyDto> {

	@Autowired
	AddressMapper addressMapper;
	
	@Autowired
	UniversityMapper universityMapper;
	
	public FacultyDto toDTO(Faculty faculty) {
		
		if(faculty == null) {
			return null;
		}
		
		FacultyDto retVal = new FacultyDto();
			retVal.setId(faculty.getId());
			retVal.setName(faculty.getName());
			retVal.setDescription(faculty.getDescription());
			retVal.setContact(faculty.getContact());
			retVal.setEmail(faculty.getEmail());
			retVal.setAddress(addressMapper.toDTO(faculty.getAddress()));
			retVal.setUniversity(universityMapper.toDTO(faculty.getUniversity()));
			retVal.setTeachers(new ArrayList<>());
			for(Teacher teacher: faculty.getTeachers()) {
				retVal.getTeachers().add("/teacher/" + teacher.getId());
			}
			retVal.setStudyCourse(new ArrayList<>());
			for(StudyCourse studyCourse: faculty.getStudyCourse()) {
				retVal.getStudyCourse().add("study-course/" + studyCourse.getId());
			}
			return retVal;

	}
	
	public Faculty toEntity(FacultyDto facultyDto) {
		if(facultyDto == null) {
			return null;		
		}
		
		Faculty faculty = new Faculty();
		
		faculty.setId(facultyDto.getId());
		faculty.setAddress(addressMapper.toEntity(facultyDto.getAddress()));
		faculty.setContact(facultyDto.getContact());
		faculty.setDescription(facultyDto.getDescription());
		faculty.setEmail(facultyDto.getDescription());
		faculty.setUniversity(universityMapper.toEntity(facultyDto.getUniversity()));
		faculty.setName(facultyDto.getName());
		faculty.setVersion(facultyDto.getVersion());
		return faculty;
				
	}
	
	public List<FacultyDto> toDTO(List<Faculty> faculty){
		if(faculty == null) {
			return null;
		}
		
		List<FacultyDto > retVal = new ArrayList<FacultyDto >();
		for (Faculty faculties: faculty) {
			retVal.add(toDTO(faculties));
		}
		return retVal;
	}

	public Collection<Faculty> toEntity(Collection<FacultyDto > facultyDto){
		if(facultyDto == null) {
			return null;
		}
		
		Collection<Faculty> faculty = new ArrayList<Faculty>(facultyDto.size());
		for(FacultyDto fDto: facultyDto) {
			faculty.add(toEntity(fDto));
		}
		
		return faculty;
	}

}
