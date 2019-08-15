package app.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class ForumReply {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Long id;
	
	
	@NotNull
	private String content;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private ForumThread forumThread;
	
	@ManyToOne
	private ForumUser author;
	
	public ForumReply() {}
	
	

	public ForumReply(Long id, @NotNull String content, ForumThread forumThread, ForumUser author) {
		super();
		this.id = id;
		this.content = content;
		this.forumThread = forumThread;
		this.author = author;
	}



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



	public ForumThread getForumThread() {
		return forumThread;
	}



	public void setForumThread(ForumThread forumThread) {
		this.forumThread = forumThread;
	}



	public ForumUser getAuthor() {
		return author;
	}



	public void setAuthor(ForumUser author) {
		this.author = author;
	}

	
	
}
