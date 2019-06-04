package app.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class ForumRole {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Long id;
	
	@NotNull
	private String name;
	
	@OneToMany(mappedBy = "role")
	private Set<ForumUserRole> users;

	public ForumRole(Long id, @NotNull String name, Set<ForumUserRole> users) {
		super();
		this.id = id;
		this.name = name;
		this.users = users;
	}
	
	public ForumRole() {}

	public ForumRole(Long id, @NotNull String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<ForumUserRole> getUsers() {
		return users;
	}

	public void setUsers(Set<ForumUserRole> users) {
		this.users = users;
	}
	
	
	
	
}
