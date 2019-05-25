package app.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.dto.AddressDto;
import app.entities.Address;
import app.entities.Student;

@Component
public class AddressMapper implements Mapper<Address, AddressDto> {
	
	@Autowired
	StudentMapper studentMapper;

	
	public AddressDto toDTO(Address address) {
		AddressDto retVal = new AddressDto();
			retVal.setId(address.getId());
			retVal.setStreet(address.getStreet());
			retVal.setStreetNumber(address.getStreet());
			retVal.setVersion(address.getVersion());
			for (Student student: address.getStudent()) {
				retVal.getStudent().add("/student/"+student.getId());
			}
			return retVal;
	}

	
	public Address toEntity(AddressDto edto) {
		return null;
	}

	
	public List<AddressDto> toDTO(List<Address> address) {
		List<AddressDto > retVal = new ArrayList<AddressDto >();
		for (Address addresses: address) {
			retVal.add(toDTO(addresses));
		}
		return retVal;
	}

	
	public List<Address> toEntity(List<AddressDto> edtos) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
