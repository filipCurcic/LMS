package app.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;



public class ForumReplyDto {
	
	@JacksonXmlProperty(isAttribute = true)
	private Long id;
	
	private String content;
	
	private ForumUserDto author;
	
	private Long ForumThreadId;
	
	private ThreadDto thread;
	
	
	

	public ThreadDto getThread() {
		return thread;
	}

	public void setThread(ThreadDto thread) {
		this.thread = thread;
	}

	public Long getForumThreadId() {
		return ForumThreadId;
	}

	public void setForumThreadId(Long forumThreadId) {
		ForumThreadId = forumThreadId;
	}

	public ForumReplyDto() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public ForumUserDto getAuthor() {
		return author;
	}

	public void setAuthor(ForumUserDto author) {
		this.author = author;
	}
	
	

}
