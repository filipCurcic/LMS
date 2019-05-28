package app.dto;

import java.util.Collection;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class FacultyDto {

	@JacksonXmlProperty(isAttribute = true)
	private Long id;
	private String name;
	private String contact;
	private String email;
	private String description;
	private Collection<String> studyCourse;
	private UniversityDto university;
	private AddressDto address;
	private Collection<String> teachers;
	@JacksonXmlProperty(isAttribute = true)
	private int version = 0;

	
	public FacultyDto() {
		
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


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Collection<String> getStudyCourse() {
		return studyCourse;
	}


	public void setStudyCourse(Collection<String> studyCourse) {
		this.studyCourse = studyCourse;
	}


	public UniversityDto getUniversity() {
		return university;
	}


	public void setUniversity(UniversityDto university) {
		this.university = university;
	}


	public AddressDto getAddress() {
		return address;
	}


	public void setAddress(AddressDto address) {
		this.address = address;
	}


	public Collection<String> getTeachers() {
		return teachers;
	}


	public void setTeachers(Collection<String> teachers) {
		this.teachers = teachers;
	}


	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}
	
	
}
