package app.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import app.dto.RegisteredUserDto;
import app.entities.RegisteredUser;

@Component
public class RegisteredUserMapper implements Mapper<RegisteredUser, RegisteredUserDto>{

	public RegisteredUserDto toDTO(RegisteredUser registeredUser) {
		RegisteredUserDto retVal = new RegisteredUserDto();
			retVal.setId(registeredUser.getId());
			retVal.setUsername(registeredUser.getUsername());
			retVal.setEmail(registeredUser.getEmail());
			retVal.setPassword(registeredUser.getPassword());
			return retVal;

	}
	
	public RegisteredUser toEntity(RegisteredUserDto registeredUserDto) {
		return null;		
	}
	
	public List<RegisteredUserDto> toDTO(List<RegisteredUser> registeredUser){
		List<RegisteredUserDto > retVal = new ArrayList<RegisteredUserDto >();
		for (RegisteredUser registeredUsers: registeredUser) {
			retVal.add(toDTO(registeredUsers));
		}
		return retVal;
	}

	public List<RegisteredUser> toEntity(List<RegisteredUserDto > registeredUserDto){
		return null;
	}

	
}
