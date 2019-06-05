package app.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class ForumUserRole {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Long id;
	
	@ManyToOne
	private ForumUser user;
	
	@ManyToOne
	private ForumRole role;

	public ForumUserRole(Long id, ForumUser user, ForumRole role) {
		super();
		this.id = id;
		this.user = user;
		this.role = role;
	}
	
	public ForumUserRole() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ForumUser getUser() {
		return user;
	}

	public void setUser(ForumUser user) {
		this.user = user;
	}

	public ForumRole getRole() {
		return role;
	}

	public void setRole(ForumRole role) {
		this.role = role;
	}
	
	
}
