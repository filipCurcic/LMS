package app.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class UserPermission {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Permission permission;
	
	@ManyToOne
	private RegisteredUser registeredUser;
	
	
	public UserPermission() {
		
	}
	

	public UserPermission(Long id, RegisteredUser registeredUser, Permission permission ) {
		this.id = id;
		this.permission = permission;
		this.registeredUser = registeredUser;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Permission getPermission() {
		return permission;
	}


	public void setPermission(Permission permission) {
		this.permission = permission;
	}


	public RegisteredUser getRegisteredUser() {
		return registeredUser;
	}


	public void setRegisteredUser(RegisteredUser registeredUser) {
		this.registeredUser = registeredUser;
	}
	
	
	
	
}
