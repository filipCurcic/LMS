package app.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;

import app.utils.View.ShowForumReply;

@Entity
public class ForumThread {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private Date dateOfCreation;
	
	@NotNull
	private String content;
	
	@ManyToOne
	private ForumFile file;
	
	@ManyToOne
	private ForumUser author;
	
	private String threadName;
	
	@JsonView(ShowForumReply.class)
	@OneToMany(mappedBy = "forumThread")
	private Set<ForumReply> replies;
	
	@ManyToOne
	private ForumSubForum subForum;

	public ForumThread(Long id, @NotNull Date dateOfCreation, @NotNull String content, ForumFile file, ForumUser author,
			Set<ForumReply> replies, ForumSubForum subForum, String threadName) {
		super();
		this.id = id;
		this.dateOfCreation = dateOfCreation;
		this.content = content;
		this.file = file;
		this.author = author;
		this.replies = replies;
		this.subForum = subForum;
		this.threadName = threadName;
	}
	
	public String getThreadName() {
		return threadName;
	}

	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}

	public ForumThread() {}

	public ForumThread(Long id, @NotNull Date dateOfCreation, @NotNull String content, ForumUser author) {
		super();
		this.id = id;
		this.dateOfCreation = dateOfCreation;
		this.content = content;
		this.author = author;
	}

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

	public ForumFile getFile() {
		return file;
	}

	public void setFile(ForumFile file) {
		this.file = file;
	}

	public ForumUser getAuthor() {
		return author;
	}

	public void setAuthor(ForumUser author) {
		this.author = author;
	}

	public Set<ForumReply> getReplies() {
		return replies;
	}

	public void setReplies(Set<ForumReply> replies) {
		this.replies = replies;
	}

	public ForumSubForum getSubForum() {
		return subForum;
	}

	public void setSubForum(ForumSubForum subForum) {
		this.subForum = subForum;
	}
	
	
	
	
	
}
