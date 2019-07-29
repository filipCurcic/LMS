package app.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import app.utils.View.ShowUserPermission;

@Entity
public class Permission {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(unique = true)
	private String title;
	
	@JsonView(ShowUserPermission.class)
	@OneToMany(mappedBy="permission")
	private Set<UserPermission> userPermission; 
	
	public Permission() {
		
	}

	public Permission(Long id, String title, Set<UserPermission> userPermission) {
		this.id = id;
		this.title = title;
		this.userPermission = userPermission;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<UserPermission> getUserPermission() {
		return userPermission;
	}

	public void setUserPermission(Set<UserPermission> userPermission) {
		this.userPermission = userPermission;
	}
	
	
	
	
	
}
