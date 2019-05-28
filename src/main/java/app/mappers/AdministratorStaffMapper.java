package app.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.dto.AdministratorStaffDto;
import app.dto.RegisteredUserDto;
import app.entities.AdministratorStaff;

@Component
public class AdministratorStaffMapper implements Mapper<AdministratorStaff, AdministratorStaffDto> {

	@Autowired
	RegisteredUserMapper registeredUserMapper;
	
	public AdministratorStaffDto toDTO(AdministratorStaff administratorStaff) {
		AdministratorStaffDto retVal = new AdministratorStaffDto();
			retVal.setId(administratorStaff.getId());
			retVal.setName(administratorStaff.getName());
			retVal.setSurname(administratorStaff.getSurname());
			retVal.setDeleted(administratorStaff.isDeleted());
			retVal.setJmbg(administratorStaff.getJmbg());
			retVal.setProfilePicturePath(administratorStaff.getProfilePicturePath());
			retVal.setRegisteredUserDto(new RegisteredUserDto());
			retVal.setRegisteredUserDto(registeredUserMapper.toDTO(administratorStaff.getRegisteredUser()));
			return retVal;

	}
	
	public AdministratorStaff toEntity(AdministratorStaffDto administratorStaffDto) {
		return null;		
	}
	
	public List<AdministratorStaffDto> toDTO(List<AdministratorStaff> administratorStaff){
		List<AdministratorStaffDto > retVal = new ArrayList<AdministratorStaffDto >();
		for (AdministratorStaff administratorStaffs: administratorStaff) {
			retVal.add(toDTO(administratorStaffs));
		}
		return retVal;
	}

	public List<AdministratorStaff> toEntity(List<AdministratorStaffDto > administratorStaffDto){
		return null;
	}

}
