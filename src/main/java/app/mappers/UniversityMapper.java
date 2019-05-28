package app.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.dto.AddressDto;
import app.dto.UniversityDto;
import app.entities.Faculty;
import app.entities.Teacher;
import app.entities.University;


@Component
public class UniversityMapper implements Mapper<University, UniversityDto> {

	
	@Autowired
	AddressMapper addressMappper;

	public UniversityDto toDTO(University university) {
		UniversityDto retVal = new UniversityDto();
			retVal.setId(university.getId());
			retVal.setName(university.getName());
			retVal.setContact(university.getContact());
			retVal.setDescription(university.getDescription());
			retVal.setEmail(university.getEmail());
			retVal.setEstablishmentDate(university.getEstablishmentDate());
			retVal.setVersion(university.getVersion());
			retVal.setAddress(new AddressDto());
			retVal.setAddress(addressMappper.toDTO(university.getAddress()));
			retVal.setTeachers(new ArrayList<>());
			for (Teacher teacher: university.getTeachers()){
				retVal.getTeachers().add("/teacher/"+teacher.getId());
			}
			retVal.setFaculties(new ArrayList<>());
			for(Faculty faculty: university.getFaculties()) {
				retVal.getFaculties().add("/faculty/" + faculty.getId());
			}
			return retVal;

	}
	
	public University toEntity(UniversityDto universityDto) {
		return null;		
	}
	
	public List<UniversityDto> toDTO(List<University> university){
		List<UniversityDto > retVal = new ArrayList<UniversityDto >();
		for (University universities: university) {
			retVal.add(toDTO(universities));
		}
		return retVal;
	}

	public List<University> toEntity(List<UniversityDto > universityDto){
		return null;
	}

}
