package app.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class ForumUserRoleDto {
	@JacksonXmlProperty(isAttribute = true)
	private Long id;
	
	private ForumUserDto forumUser;
	private ForumRoleDto forumRole;
	
	public ForumUserRoleDto() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ForumUserDto getForumUser() {
		return forumUser;
	}

	public void setForumUser(ForumUserDto forumUser) {
		this.forumUser = forumUser;
	}

	public ForumRoleDto getForumRole() {
		return forumRole;
	}

	public void setForumRole(ForumRoleDto forumRole) {
		this.forumRole = forumRole;
	}
	
	

}
