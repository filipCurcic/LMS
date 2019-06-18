package app.dto;



import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class ForumRoleDto {
	@JacksonXmlProperty(isAttribute = true)
	private Long id;
	
	private String name;
	
	
	public ForumRoleDto() {}

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
