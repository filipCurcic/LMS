package app.dto;

import java.util.Collection;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class UniversityDto {

	@JacksonXmlProperty(isAttribute = true)
	private Long id;
	@JacksonXmlProperty(isAttribute = true)
	private int version = 0;
	private String name;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date establishmentDate;
	private String contact;
	private String email;
	private String description;
	private Collection<String> faculties;
	private Collection<String> teachers;
	private AddressDto address;
	
	public UniversityDto() {
		
	}

	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getEstablishmentDate() {
		return establishmentDate;
	}

	public void setEstablishmentDate(Date establishmentDate) {
		this.establishmentDate = establishmentDate;
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

	
	public Collection<String> getTeachers() {
		return teachers;
	}

	public void setTeachers(Collection<String> teachers) {
		this.teachers = teachers;
	}


	public AddressDto getAddress() {
		return address;
	}


	public void setAddress(AddressDto address) {
		this.address = address;
	}


	public Collection<String> getFaculties() {
		return faculties;
	}


	public void setFaculties(Collection<String> faculties) {
		this.faculties = faculties;
	}
	
	
	



	
	
	
}
