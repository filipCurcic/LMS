package app.dto;

import java.util.Collection;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import app.entities.ForumSubFacultyForum;

public class ForumDto {
	@JacksonXmlProperty(isAttribute = true)
	private Long id;
	private boolean publicForum;
	private Collection<String> subForums;
	
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
