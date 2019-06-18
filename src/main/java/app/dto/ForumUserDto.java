package app.dto;

import java.util.Collection;
import java.util.Set;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class ForumUserDto {
	@JacksonXmlProperty(isAttribute = true)
	private Long id;

	private RegisteredUserDto registeredUser;
	
	private Collection<Long> startedThreads;
	
	private Collection<Long> replies;
	
	private Collection<Long> roles;
	
	private Collection<Long> replyIds;
	
	private Collection<Long> roleIds;
	
	private Collection<Long> startedThreadIds;

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

	public Collection<Long> getStartedThreads() {
		return startedThreads;
	}

	public void setStartedThreads(Collection<Long> startedThreads) {
		this.startedThreads = startedThreads;
	}

	public Collection<Long> getReplies() {
		return replies;
	}

	public void setReplies(Collection<Long> replies) {
		this.replies = replies;
	}

	public Collection<Long> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Long> roles) {
		this.roles = roles;
	}

	public Collection<Long> getReplyIds() {
		return replyIds;
	}

	public void setReplyIds(Collection<Long> replyIds) {
		this.replyIds = replyIds;
	}

	public Collection<Long> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(Collection<Long> roleIds) {
		this.roleIds = roleIds;
	}

	public Collection<Long> getStartedThreadIds() {
		return startedThreadIds;
	}

	public void setStartedThreadIds(Collection<Long> startedThreadIds) {
		this.startedThreadIds = startedThreadIds;
	}

	public ForumUserDto() {
		super();
	}
	
	
	



	


	
	
}
