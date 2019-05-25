package app.dto;

import java.util.Collection;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class CountryDto {

	@JacksonXmlProperty(isAttribute = true)
	private Long id;
	private String name;
	@JacksonXmlProperty(isAttribute = true)
	private int version = 0;
	private Collection<String> city;
	
	
	
	public CountryDto() {
		
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
	
	public Collection<String> getCity() {
		return city;
	}
	
	public void setCity(Collection<String> city) {
		this.city = city;
	}
	
	


}
