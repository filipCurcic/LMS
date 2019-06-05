package app.dto;

import java.util.Collection;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import app.entities.ForumThread;

public class SubForumDto {
	

	@JacksonXmlProperty(isAttribute = true)
	private Long id;
	
	private String name;
	private StudyCourseDto studyCourse;
	private Collection<ForumThread> threads;
	
	public SubForumDto() {}
	
	
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
	public StudyCourseDto getStudyCourse() {
		return studyCourse;
	}
	public void setStudyCourse(StudyCourseDto studyCourse) {
		this.studyCourse = studyCourse;
	}
	public Collection<ForumThread> getThreads() {
		return threads;
	}
	public void setThreads(Collection<ForumThread> threads) {
		this.threads = threads;
	}
	

}
