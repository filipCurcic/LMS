package app.dto;

import java.util.Collection;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class CountryDto {

	@JacksonXmlProperty(isAttribute = true)
	private Long id;
	private String name;
	
	
	
	public CountryDto() {
		
	}
	
	
	
	public CountryDto(String name) {
		this.name = name;
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
	
	
	
	
	
	


}
