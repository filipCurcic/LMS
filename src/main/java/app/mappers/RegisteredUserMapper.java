package app.mappers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import app.dto.RegisteredUserDto;
import app.entities.RegisteredUser;

@Component
public class RegisteredUserMapper implements Mapper<RegisteredUser, RegisteredUserDto>{

	public RegisteredUserDto toDTO(RegisteredUser registeredUser) {
		
		if(registeredUser == null) {
			return null;
		}
		
		RegisteredUserDto retVal = new RegisteredUserDto();
			retVal.setId(registeredUser.getId());
			retVal.setUsername(registeredUser.getUsername());
			retVal.setEmail(registeredUser.getEmail());
			retVal.setPassword(registeredUser.getPassword());
			return retVal;

	}
	
	public Collection<RegisteredUser> toEntity(Collection<RegisteredUserDto> registeredUserDto) {
		if(registeredUserDto == null) {
			return null;		
		}
		
		Collection<RegisteredUser> registeredUser = new ArrayList<RegisteredUser>(registeredUserDto.size());
		for(RegisteredUserDto rDto : registeredUserDto) {
			registeredUser.add(toEntity(rDto));
		}
		
		return registeredUser;
	}
	
	public List<RegisteredUserDto> toDTO(List<RegisteredUser> registeredUser){
		
		if(registeredUser == null) {
			return null;
		}
		
		List<RegisteredUserDto > retVal = new ArrayList<RegisteredUserDto >();
		for (RegisteredUser registeredUsers: registeredUser) {
			retVal.add(toDTO(registeredUsers));
		}
		return retVal;
	}

	public RegisteredUser toEntity(RegisteredUserDto registeredUserDto){
		if(registeredUserDto == null) {
			return null;
		}
		
		RegisteredUser registeredUser = new RegisteredUser();
		registeredUser.setId(registeredUserDto.getId());
		registeredUser.setUsername(registeredUserDto.getUsername());
		registeredUser.setEmail(registeredUserDto.getEmail());
		registeredUser.setPassword(registeredUserDto.getPassword());
		return registeredUser;
	}

	
}
