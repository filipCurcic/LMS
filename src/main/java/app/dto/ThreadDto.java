package app.dto;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class ThreadDto {
	@JacksonXmlProperty(isAttribute = true)
	private Long id;
	private Date dateOfCreation;
	private String content;
	private ForumFileDto file;
	private ForumUserDto author;
	private Collection<String> replyEndpoints;
	private Set<ForumReplyDto> replies;
	private SubForumDto subForum;
	
	
	

	public SubForumDto getSubForum() {
		return subForum;
	}


	public void setSubForum(SubForumDto subForum) {
		this.subForum = subForum;
	}


	public Set<ForumReplyDto> getReplies() {
		return replies;
	}


	public void setReplies(Set<ForumReplyDto> replies) {
		this.replies = replies;
	}


	public ThreadDto() {}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getDateOfCreation() {
		return dateOfCreation;
	}


	public void setDateOfCreation(Date dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public ForumFileDto getFile() {
		return file;
	}


	public void setFile(ForumFileDto file) {
		this.file = file;
	}


	public ForumUserDto getAuthor() {
		return author;
	}


	public void setAuthor(ForumUserDto author) {
		this.author = author;
	}


	public Collection<String> getReplyEndpoints() {
		return replyEndpoints;
	}


	public void setReplyEndpoints(Collection<String> replyEndpoints) {
		this.replyEndpoints = replyEndpoints;
	}


	
	
	
	
	
}
