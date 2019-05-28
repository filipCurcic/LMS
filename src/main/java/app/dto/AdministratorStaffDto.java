package app.dto;


import org.springframework.stereotype.Component;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;


@Component
public class AdministratorStaffDto {
	
	@JacksonXmlProperty(isAttribute=true)
	private Long id;
	private String name;
	private String surname;
	private String jmbg;
	private boolean deleted = false;
	private String profilePicturePath;
	private RegisteredUserDto registeredUserDto;
	
	public AdministratorStaffDto() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public String getProfilePicturePath() {
		return profilePicturePath;
	}

	public void setProfilePicturePath(String profilePicturePath) {
		this.profilePicturePath = profilePicturePath;
	}

	public RegisteredUserDto getRegisteredUserDto() {
		return registeredUserDto;
	}

	public void setRegisteredUserDto(RegisteredUserDto registeredUserDto) {
		this.registeredUserDto = registeredUserDto;
	}
	
	
}
