package app.dto;

import java.util.Collection;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class StudentDto {
	
	@JacksonXmlProperty(isAttribute = true)
	private Long id;
	private String name;
	private String lastName;
	private String jmbg;
	private String profilePicturePath;
	private RegisteredUserDto registeredUserDto;
	private AddressDto addressDto;
	private Collection<String> studentYear;
	
	public StudentDto() {
		
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
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getJmbg() {
		return jmbg;
	}
	
	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
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

	public AddressDto getAddressDto() {
		return addressDto;
	}

	public void setAddressDto(AddressDto addressDto) {
		this.addressDto = addressDto;
	}

	public Collection<String> getStudentYear() {
		return studentYear;
	}

	public void setStudentYear(Collection<String> studentYear) {
		this.studentYear = studentYear;
	}
	
	
	

}
