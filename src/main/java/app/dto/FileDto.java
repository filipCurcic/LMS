package app.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class FileDto {

	@JacksonXmlProperty(isAttribute=true)
	private Long id;
	private String description;
	private String url;
	
	public FileDto() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
