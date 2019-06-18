package app.mappers;

import java.util.ArrayList;
import java.util.Collection;
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
		
		if(address == null) {
			return null;
		}
		
		AddressDto retVal = new AddressDto();
			retVal.setId(address.getId());
			retVal.setStreet(address.getStreet());
			retVal.setStreetNumber(address.getStreetNumber());
			retVal.setCity(cityMapper.toDTO(address.getCity()));
			return retVal;
	}

	
	public Collection<Address> toEntity(Collection<AddressDto> addressDto) {
		if ( addressDto == null ) {
            return null;
        }	
		
		Collection<Address> address = new ArrayList<>(addressDto.size());
		for(AddressDto aDto : addressDto) {
			address.add( toEntity(aDto));
		}
		
		return address;
	}
	
	public List<AddressDto> toDTO(List<Address> address){
		
		if(address == null) {
			return null;
		}
		
		List<AddressDto > retVal = new ArrayList<AddressDto >();
		for (Address addresses: address) {
			retVal.add(toDTO(addresses));
		}
		return retVal;
	}

	public Address toEntity(AddressDto addressDto){
		if ( addressDto == null ) {
            return null;
        }	
		
		Address address = new Address();
		
		address.setId(addressDto.getId());
		address.setStreet(addressDto.getStreet());
		address.setStreetNumber(address.getStreetNumber());
		return address;
	}

}
