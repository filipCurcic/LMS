package app.mappers;

import java.util.ArrayList;
import java.util.Collection;
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
		
		if(university == null) {
			return null;
		}
		
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
		if(universityDto == null) {
			return null;		
		}
		
		University university = new University();
		
		university.setId(universityDto.getId());
		university.setContact(universityDto.getContact());
		university.setDescription(universityDto.getDescription());
		university.setEmail(universityDto.getEmail());
		university.setEstablishmentDate(universityDto.getEstablishmentDate());
		university.setName(universityDto.getName());
		university.setAddress(addressMappper.toEntity(universityDto.getAddress()));
		university.setVersion(universityDto.getVersion());
		
		return university;
	}
	
	public List<UniversityDto> toDTO(List<University> university){
		
		if(university == null) {
			return null;
		}
		
		List<UniversityDto > retVal = new ArrayList<UniversityDto >();
		for (University universities: university) {
			retVal.add(toDTO(universities));
		}
		return retVal;
	}

	public Collection<University> toEntity(Collection<UniversityDto > universityDto){
		if(universityDto == null) {
			return null;
		}
		
		Collection<University> university = new ArrayList<University>(universityDto.size());
		for(UniversityDto uDto: universityDto) {
			university.add(toEntity(uDto));
		}
		
		return university;
	}

}
