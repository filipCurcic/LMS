package app.dto;

import java.util.Collection;
import java.util.Set;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import app.entities.ForumSubFacultyForum;

public class ForumDto {
	@JacksonXmlProperty(isAttribute = true)
	private Long id;
	private boolean publicForum;
	private Collection<String> subForums;
	private Collection<String> users;
	private Collection<ForumSubFacultyForum> SubForumsObjects;
	
	
	public Collection<ForumSubFacultyForum> getSubForumsObjects() {
		return SubForumsObjects;
	}

	public void setSubForumsObjects(Set<ForumSubFacultyForum> set) {
		SubForumsObjects = set;
	}

	public Collection<String> getUsers() {
		return users;
	}

	public void setUsers(Collection<String> users) {
		this.users = users;
	}

	public ForumDto() {}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isPublicForum() {
		return publicForum;
	}
	public void setPublicForum(boolean publicForum) {
		this.publicForum = publicForum;
	}
	public Collection<String> getSubForums() {
		return subForums;
	}
	public void setSubForums(Collection<String> subForums) {
		this.subForums = subForums;
	}
	
	
}
