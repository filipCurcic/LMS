package app.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Forum {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private boolean publicForum;
	
	@OneToMany(mappedBy = "forum")
	private Set<ForumSubFacultyForum> subForums;

	
	@OneToMany(mappedBy = "forum")
	private Set<ForumUser> users;
	
	public Forum() {}

	public Forum(Long id, @NotNull boolean publicForum, Set<ForumSubFacultyForum> subForums, Set<ForumUser> users) {
		super();
		this.id = id;
		this.publicForum = publicForum;
		this.subForums = subForums;
		this.users = users;
	}


	public Forum(Long id, @NotNull boolean publicForum) {
		super();
		this.id = id;
		this.publicForum = publicForum;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public boolean isPublicForum() {
		return publicForum;
	}


	public void setPublicForum(boolean publicForum) {
		this.publicForum = publicForum;
	}


	public Set<ForumSubFacultyForum> getSubForums() {
		return subForums;
	}


	public void setSubForums(Set<ForumSubFacultyForum> subForums) {
		this.subForums = subForums;
	}


	public Set<ForumUser> getUsers() {
		return users;
	}


	public void setUsers(Set<ForumUser> users) {
		this.users = users;
	}
	
	
	
	
	
	
}
