package app.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.dto.AddressDto;
import app.dto.CityDto;
import app.entities.Address;
import app.entities.Student;
import app.entities.Teacher;

@Component
public class AddressMapper implements Mapper<Address, AddressDto> {
	
	@Autowired
	CityMapper cityMapper;

	
	public AddressDto toDTO(Address address) {
		AddressDto retVal = new AddressDto();
			retVal.setId(address.getId());
			retVal.setStreet(address.getStreet());
			retVal.setStreetNumber(address.getStreetNumber());
			retVal.setCityDto(new CityDto());
			retVal.setCityDto(cityMapper.toDTO(address.getCity()));
			retVal.setStudent(new ArrayList<>());
			for(Student student: address.getStudent()) {
				retVal.getStudent().add("/student/" + student.getId());
			}
			retVal.setTeacher(new ArrayList<>());
			for(Teacher teacher: address.getTeacher()) {
				retVal.getTeacher().add("/teacher/" + teacher.getId());
			}
			return retVal;
	}

	
	public Address toEntity(AddressDto addressDto) {
		return null;		
	}
	
	public List<AddressDto> toDTO(List<Address> address){
		List<AddressDto > retVal = new ArrayList<AddressDto >();
		for (Address addresses: address) {
			retVal.add(toDTO(addresses));
		}
		return retVal;
	}

	public List<Address> toEntity(List<AddressDto > addressDto){
		return null;
	}

}
