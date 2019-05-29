package app.mappers;

import java.util.ArrayList;
import java.util.Collection;
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
		
		if(administrator == null) {
			return null;
		}
		
		AdministratorDto retVal = new AdministratorDto();
			retVal.setId(administrator.getId());
			retVal.setRegisteredUserDto(new RegisteredUserDto());
			retVal.setRegisteredUserDto(registeredUserMapper.toDTO(administrator.getRegisteredUser()));
			return retVal;

	}
	
	public Collection<Administrator> toEntity(Collection<AdministratorDto> administratorDto) {
		if(administratorDto == null) {
			return null;		
		}
		
		Collection<Administrator> administrator = new ArrayList<Administrator>(administratorDto.size());
		for(AdministratorDto aDto: administratorDto) {
			administrator.add(toEntity(aDto));
		}
		
		return administrator;
	}
	
	public List<AdministratorDto> toDTO(List<Administrator> administrator){
		
		if(administrator == null) {
			return null;
		}
		
		List<AdministratorDto > retVal = new ArrayList<AdministratorDto >();
		for (Administrator administrators: administrator) {
			retVal.add(toDTO(administrators));
		}
		return retVal;
	}

	
	public Administrator toEntity(AdministratorDto administratorDto) {
		if(administratorDto == null) {
			return null;
		}
		
		Administrator administrator = new Administrator();
		administrator.setId(administratorDto.getId());
		administrator.setRegisteredUser(registeredUserMapper.toEntity(administratorDto.getRegisteredUserDto()));
		return administrator;
	}

}
