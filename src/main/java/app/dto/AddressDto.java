package app.dto;

import java.util.Collection;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class AddressDto {
	
	@JacksonXmlProperty(isAttribute = true)
	private Long id;
	private String street;
	private String streetNumber;
	private CityDto city;
	
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


	public CityDto getCity() {
		return city;
	}

	public void setCity(CityDto city) {
		this.city = city;
	}

		
	
}
