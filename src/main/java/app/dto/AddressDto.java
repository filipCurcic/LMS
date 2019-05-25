package app.dto;

import java.util.Collection;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class AddressDto {

	@JacksonXmlProperty(isAttribute = true)
	private Long id;
	private String street;
	private String streetNumber;
	@JacksonXmlProperty(isAttribute = true)
	private int version = 0;
	private Collection<String> student;
	
	public  AddressDto() {
		
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

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Collection<String> getStudent() {
		return student;
	}

	public void setStudent(Collection<String> student) {
		this.student = student;
	}

	
}
