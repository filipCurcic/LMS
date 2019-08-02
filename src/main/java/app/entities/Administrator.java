package app.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Where;

@Entity
public class Administrator{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private RegisteredUser registeredUser;
	
	public Administrator() {
		
	}

	
	public Administrator(Long id, RegisteredUser registeredUser) {
		this.id = id;
		this.registeredUser = registeredUser;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public RegisteredUser getRegisteredUser() {
		return registeredUser;
	}


	public void setRegisteredUser(RegisteredUser registeredUser) {
		this.registeredUser = registeredUser;
	}
	
	
	
	
	
	
	
}
