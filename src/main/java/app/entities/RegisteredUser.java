package app.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class RegisteredUser {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Column(unique = true, length = 55)
	private String username;
	@NotNull
	
	private String password;
	@NotNull
	private String email;
	
	@OneToMany(mappedBy="registeredUser", cascade = CascadeType.ALL)
	private Set<UserPermission> userPermission;
	
//	@OneToMany(mappedBy = "registeredUser")
//	private Set<ForumUser> forumUser;
	
	public RegisteredUser() {
		
	}
	
	
	public RegisteredUser(String username, String password, String email, Set<UserPermission> userPermission) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.userPermission = userPermission;
	}

	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public Set<UserPermission> getUserPermission() {
		return userPermission;
	}


	public void setUserPermission(Set<UserPermission> userPermission) {
		this.userPermission = userPermission;
	}

	
	
	
	
}
