package app.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.dto.AdministratorDto;
import app.dto.RegisteredUserDto;
import app.entities.Administrator;

@Component
public class AdministratorMapper implements Mapper<Administrator, AdministratorDto> {

	@Autowired
	RegisteredUserMapper registeredUserMapper;
	
	public AdministratorDto toDTO(Administrator administrator) {
		AdministratorDto retVal = new AdministratorDto();
			retVal.setId(administrator.getId());
			retVal.setRegisteredUserDto(new RegisteredUserDto());
			retVal.setRegisteredUserDto(registeredUserMapper.toDTO(administrator.getRegisteredUser()));
			return retVal;

	}
	
	public Administrator toEntity(AdministratorDto administratorDto) {
		return null;		
	}
	
	public List<AdministratorDto> toDTO(List<Administrator> administrator){
		List<AdministratorDto > retVal = new ArrayList<AdministratorDto >();
		for (Administrator administrators: administrator) {
			retVal.add(toDTO(administrators));
		}
		return retVal;
	}

	public List<Administrator> toEntity(List<AdministratorDto > administratorDto){
		return null;
	}

}
