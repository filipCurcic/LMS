package app.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ForumUser {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Long id;
	
	@ManyToOne
	private Forum forum;
	
	@ManyToOne
	private RegisteredUser registeredUser;
	
	@OneToMany(mappedBy = "author")
	private Set<ForumThread> startedThreads;
	
	@OneToMany(mappedBy = "author")
	private Set<ForumReply> replies;
	
	@OneToMany(mappedBy = "user")
	private Set<ForumUserRole> roles;

	
	public ForumUser() {
	}
	
	
	

	public ForumUser(Long id, RegisteredUser registeredUser, Set<ForumUserRole> roles) {
		super();
		this.id = id;
		this.registeredUser = registeredUser;
		this.roles = roles;
	}




	public ForumUser(Long id, Forum forum, RegisteredUser registeredUser, Set<ForumThread> startedThreads,
			Set<ForumReply> replies, Set<ForumUserRole> roles) {
		super();
		this.id = id;
		this.forum = forum;
		this.registeredUser = registeredUser;
		this.startedThreads = startedThreads;
		this.replies = replies;
		this.roles = roles;
	}




	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Forum getForum() {
		return forum;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
	}

	public RegisteredUser getRegisteredUser() {
		return registeredUser;
	}

	public void setRegisteredUser(RegisteredUser registeredUser) {
		this.registeredUser = registeredUser;
	}

	public Set<ForumThread> getStartedThreads() {
		return startedThreads;
	}

	public void setStartedThreads(Set<ForumThread> startedThreads) {
		this.startedThreads = startedThreads;
	}

	public Set<ForumReply> getReplies() {
		return replies;
	}

	public void setReplies(Set<ForumReply> replies) {
		this.replies = replies;
	}

	public Set<ForumUserRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<ForumUserRole> roles) {
		this.roles = roles;
	}
	
	
}
