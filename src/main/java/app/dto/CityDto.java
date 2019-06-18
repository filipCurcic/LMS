package app.dto;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class CityDto {

	@JacksonXmlProperty(isAttribute = true)
	private Long id;
	private String name;
	@JacksonXmlProperty(isAttribute = true)
	private int version = 0;
	private CountryDto country;
	
	
	public CityDto() {
		
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
	
	public int getVersion() {
		return version;
	}
	
	public void setVersion(int version) {
		this.version = version;
	}



	public CountryDto getCountry() {
		return country;
	}


	public void setCountry(CountryDto country) {
		this.country = country;
	}


	


	
	

	

}
