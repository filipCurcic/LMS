package app.mappers;

import java.util.ArrayList;
import java.util.Collection;
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
		
		if(administratorStaff == null) {
			return null;
		}
		
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
		if(administratorStaffDto == null) {
			return null;		
		}
		
		AdministratorStaff administratorStaff = new AdministratorStaff();
		
		administratorStaff.setId(administratorStaffDto.getId());
		administratorStaff.setJmbg(administratorStaffDto.getJmbg());
		administratorStaff.setName(administratorStaffDto.getName());
		administratorStaff.setProfilePicturePath(administratorStaffDto.getProfilePicturePath());
		administratorStaff.setSurname(administratorStaffDto.getSurname());
		administratorStaff.setRegisteredUser(registeredUserMapper.toEntity(administratorStaffDto.getRegisteredUserDto()));
		
		return administratorStaff;
	}
	
	public List<AdministratorStaffDto> toDTO(List<AdministratorStaff> administratorStaff){
		
		if(administratorStaff == null) {
			return null;
		}
		
		List<AdministratorStaffDto > retVal = new ArrayList<AdministratorStaffDto >();
		for (AdministratorStaff administratorStaffs: administratorStaff) {
			retVal.add(toDTO(administratorStaffs));
		}
		return retVal;
	}

	@Override
	public Collection<AdministratorStaff> toEntity(Collection<AdministratorStaffDto> administratorStaff) {
		if(administratorStaff == null) {
			return null;
		}
		
		Collection<AdministratorStaff> administrator = new ArrayList<AdministratorStaff>(administratorStaff.size());
		for(AdministratorStaffDto aDto: administratorStaff) {
			administrator.add(toEntity(aDto));
		}
		
		return administrator;
	}


}
