package app.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Message {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(length=128, nullable = false)
	private String content;
	
	@Column(nullable = false)
	private Date date;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Teacher recipient;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Teacher sender;
	
	@OneToMany(mappedBy="message")
	private Set<File> attachments;

	public Message() {
		super();
	}

	public Message(String content, Date date, Teacher recipient, Teacher sender, Set<File> attachments) {
		super();
		this.content = content;
		this.date = date;
		this.recipient = recipient;
		this.sender = sender;
		this.attachments = attachments;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	public Teacher getRecipient() {
		return recipient;
	}

	public void setRecipient(Teacher recipient) {
		this.recipient = recipient;
	}

	public Teacher getSender() {
		return sender;
	}

	public void setSender(Teacher sender) {
		this.sender = sender;
	}

	public Set<File> getAttachments() {
		return attachments;
	}

	public void setAttachments(Set<File> attachments) {
		this.attachments = attachments;
	}
}
