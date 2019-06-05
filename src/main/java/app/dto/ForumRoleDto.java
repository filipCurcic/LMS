package app.dto;

import java.util.Collection;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class ForumRoleDto {
	@JacksonXmlProperty(isAttribute = true)
	private Long id;
	
	private String name;
	
	private Collection<String> users;
	
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

	public Collection<String> getUsers() {
		return users;
	}

	public void setUsers(Collection<String> users) {
		this.users = users;
	}
	
	
}
