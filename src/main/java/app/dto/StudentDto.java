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
	private RegisteredUserDto registeredUser;
	private AddressDto address;
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

	
	public RegisteredUserDto getRegisteredUser() {
		return registeredUser;
	}

	public void setRegisteredUser(RegisteredUserDto registeredUser) {
		this.registeredUser = registeredUser;
	}

	public AddressDto getAddress() {
		return address;
	}

	public void setAddress(AddressDto address) {
		this.address = address;
	}

	public Collection<String> getStudentYear() {
		return studentYear;
	}

	public void setStudentYear(Collection<String> studentYear) {
		this.studentYear = studentYear;
	}
	
	
	

}
