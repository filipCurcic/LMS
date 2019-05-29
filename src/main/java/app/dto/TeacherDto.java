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
	private Collection<String> teachersOnRealization;
	private Collection<String> studyCourseTeacher;
	private Collection<String> titles;
	private UniversityDto universityDto;
	private FacultyDto facultyDto;
	private RegisteredUserDto registeredUserDto;
	private AddressDto addressDto;
	public AddressDto getAddressDto() {
		return addressDto;
	}

	public void setAddressDto(AddressDto addressDto) {
		this.addressDto = addressDto;
	}

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

	public Collection<String> getTeachersOnRealization() {
		return teachersOnRealization;
	}

	public void setTeachersOnRealization(Collection<String> teachersOnRealization) {
		this.teachersOnRealization = teachersOnRealization;
	}

	public Collection<String> getStudyCourseTeacher() {
		return studyCourseTeacher;
	}

	public void setStudyCourseTeacher(Collection<String> studyCourseTeacher) {
		this.studyCourseTeacher = studyCourseTeacher;
	}

	public Collection<String> getTitles() {
		return titles;
	}

	public void setTitles(Collection<String> titles) {
		this.titles = titles;
	}

	public UniversityDto getUniversityDto() {
		return universityDto;
	}

	public void setUniversityDto(UniversityDto universityDto) {
		this.universityDto = universityDto;
	}

	public FacultyDto getFacultyDto() {
		return facultyDto;
	}

	public void setFacultyDto(FacultyDto facultyDto) {
		this.facultyDto = facultyDto;
	}

	public RegisteredUserDto getRegisteredUserDto() {
		return registeredUserDto;
	}

	public void setRegisteredUserDto(RegisteredUserDto registeredUserDto) {
		this.registeredUserDto = registeredUserDto;
	}
	
	
	

}
