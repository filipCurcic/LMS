package app.dto;


import java.util.Collection;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class TeacherDto {
	
	@JacksonXmlProperty(isAttribute = true)
	private Long id;
	private String name;
	private String lastName;
	private String biography;
	private String umcn;
	private String profilePicturePath;
	private AddressDto address;
	private UniversityDto university;
	private FacultyDto faculty;
	private RegisteredUserDto registeredUser;
	
	public TeacherDto() {
		
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

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public String getUmcn() {
		return umcn;
	}

	public void setUmcn(String umcn) {
		this.umcn = umcn;
	}

	public String getProfilePicturePath() {
		return profilePicturePath;
	}

	public void setProfilePicturePath(String profilePicturePath) {
		this.profilePicturePath = profilePicturePath;
	}

	
	
	public AddressDto getAddress() {
		return address;
	}

	public void setAddress(AddressDto address) {
		this.address = address;
	}

	public UniversityDto getUniversity() {
		return university;
	}

	public void setUniversity(UniversityDto university) {
		this.university = university;
	}

	public FacultyDto getFaculty() {
		return faculty;
	}

	public void setFaculty(FacultyDto faculty) {
		this.faculty = faculty;
	}

	public RegisteredUserDto getRegisteredUser() {
		return registeredUser;
	}

	public void setRegisteredUser(RegisteredUserDto registeredUser) {
		this.registeredUser = registeredUser;
	}


	

}
