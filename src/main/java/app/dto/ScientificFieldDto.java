package app.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class ScientificFieldDto {

	@JacksonXmlProperty(isAttribute = true)
	private Long id;
	private String name;
	@JacksonXmlProperty(isAttribute = true)
	private int version = 0;
	
	public ScientificFieldDto() {
		
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
	
	
}