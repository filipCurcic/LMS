package app.dto;

import java.util.Collection;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class SubFacultyForumDto {
	@JacksonXmlProperty(isAttribute = true)
	private Long id;
	private FacultyDto faculty;
	private Collection<String> subForums;
	
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

	public Collection<String> getSubForums() {
		return subForums;
	}

	public void setSubForums(Collection<String> subForums) {
		this.subForums = subForums;
	}
	
	
	
	
}
