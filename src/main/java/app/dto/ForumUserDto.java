package app.dto;

import java.util.Collection;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class ForumUserDto {
	@JacksonXmlProperty(isAttribute = true)
	private Long id;

	private RegisteredUserDto registeredUser;
	
	private Collection<String> startedThreads;
	
	private Collection<String> replies;
	
	private Collection<String> roles;
	
	
	public ForumUserDto() {}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public RegisteredUserDto getRegisteredUser() {
		return registeredUser;
	}


	public void setRegisteredUser(RegisteredUserDto registeredUser) {
		this.registeredUser = registeredUser;
	}


	public Collection<String> getStartedThreads() {
		return startedThreads;
	}


	public void setStartedThreads(Collection<String> startedThreads) {
		this.startedThreads = startedThreads;
	}


	public Collection<String> getReplies() {
		return replies;
	}


	public void setReplies(Collection<String> replies) {
		this.replies = replies;
	}


	public Collection<String> getRoles() {
		return roles;
	}


	public void setRoles(Collection<String> roles) {
		this.roles = roles;
	}
	
}
