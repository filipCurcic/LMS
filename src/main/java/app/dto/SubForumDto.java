package app.dto;

import java.util.Collection;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import app.entities.ForumSubFacultyForum;

public class SubForumDto {
	

	@JacksonXmlProperty(isAttribute = true)
	private Long id;
	
	private String name;
	private Long studyCourseId;
	private Collection<ThreadDto> threads;
	
	private Collection<String> threadEndpoints;
	
	private Long SubFacultyForumId;
	private SubFacultyForumDto subFacultyForumDto;
	
	
	public SubForumDto() {}
	
	
	
	
	



	public SubFacultyForumDto getSubFacultyForumDto() {
		return subFacultyForumDto;
	}








	public void setSubFacultyForumDto(SubFacultyForumDto subFacultyForumDto) {
		this.subFacultyForumDto = subFacultyForumDto;
	}








	public Long getSubFacultyForumId() {
		return SubFacultyForumId;
	}




	public void setSubFacultyForumId(Long subFacultyForumId) {
		SubFacultyForumId = subFacultyForumId;
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
	public Long getStudyCourseId() {
		return studyCourseId;
	}
	public void setStudyCourseId(Long id) {
		this.studyCourseId = id;
	}
	public Collection<ThreadDto> getThreads() {
		return threads;
	}
	public void setThreads(Collection<ThreadDto> threads) {
		this.threads = threads;
	}




	public Collection<String> getThreadEndpoints() {
		return threadEndpoints;
	}




	public void setThreadEndpoints(Collection<String> threadEndpoints) {
		this.threadEndpoints = threadEndpoints;
	}
	

}
