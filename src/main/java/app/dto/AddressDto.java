package app.dto;

import java.util.Collection;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class AddressDto {
	
	@JacksonXmlProperty(isAttribute = true)
	private Long id;
	private String street;
	private String streetNumber;
	private CityDto cityDto;
	private Collection<String> student;
	private Collection<String> teacher;
	
	public AddressDto() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public CityDto getCityDto() {
		return cityDto;
	}

	public void setCityDto(CityDto cityDto) {
		this.cityDto = cityDto;
	}

	public Collection<String> getStudent() {
		return student;
	}

	public void setStudent(Collection<String> student) {
		this.student = student;
	}

	public Collection<String> getTeacher() {
		return teacher;
	}

	public void setTeacher(Collection<String> teacher) {
		this.teacher = teacher;
	}
	
	
}
