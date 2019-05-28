package app.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class AdministratorDto {

	@JacksonXmlProperty(isAttribute = true)
	private Long id;
	private RegisteredUserDto registeredUserDto;
	
	public AdministratorDto() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RegisteredUserDto getRegisteredUserDto() {
		return registeredUserDto;
	}

	public void setRegisteredUserDto(RegisteredUserDto registeredUserDto) {
		this.registeredUserDto = registeredUserDto;
	}
	
	
}
