package app.dto;

import java.util.Collection;
import java.util.Set;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import app.entities.Forum;
import app.entities.ForumSubForum;

public class SubFacultyForumDto {
	@JacksonXmlProperty(isAttribute = true)
	private Long id;
	private FacultyDto faculty;
	private Collection<SubForumDto> subForums;
	private Collection<String> subForumEndpoints;
	private Long forumId;
	private ForumDto forum;
	
	public SubFacultyForumDto() {}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public FacultyDto getFaculty() {
		return faculty;
	}
	public void setFaculty(FacultyDto faculty) {
		this.faculty = faculty;
	}
	public Collection<SubForumDto> getSubForums() {
		return subForums;
	}
	public void setSubForums(Collection<SubForumDto> subForums) {
		this.subForums = subForums;
	}
	public Collection<String> getSubForumEndpoints() {
		return subForumEndpoints;
	}
	public void setSubForumEndpoints(Collection<String> subForumEndpoints) {
		this.subForumEndpoints = subForumEndpoints;
	}
	public Long getForumId() {
		return forumId;
	}
	public void setForumId(Long forumId) {
		this.forumId = forumId;
	}
	public ForumDto getForum() {
		return forum;
	}
	public void setForum(ForumDto forum) {
		this.forum = forum;
	}
	
	
	
	
	

	
	
	
	
}
