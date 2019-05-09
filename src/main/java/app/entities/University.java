package app.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

@Entity
public class University {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String name;
	
	@NotNull
	private Date establishmentDate;
	
	@NotNull
	private String contact;
	
	@NotNull
	private String email;
	
	@NotNull
	private String description;
	
	
	@OneToMany(mappedBy="university")
	private Set<Faculty> faculties;
	
	@OneToOne
	@JoinColumn(name="addressId")
	private Address address;
		
	@OneToMany(mappedBy="university")
	private Set<Teacher> teachers;
	
	@Version
	private int version = 0;
	
	public University () {
		
	}

	
	public University(String name,Date establishmentDate, String contact,
			String email, String description, Set<Faculty> faculties, Address address,
			Set<Teacher> teachers, int version) {
		this.name = name;
		this.establishmentDate = establishmentDate;
		this.contact = contact;
		this.email = email;
		this.description = description;
		this.faculties = faculties;
		this.address = address;
		this.teachers = teachers;
		this.version = version;
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
	
	
	public Date getEstablishmentDate() {
		return establishmentDate;
	}







	public void setEstablishmentDate(Date establishmentDate) {
		this.establishmentDate = establishmentDate;
	}







	public String getContact() {
		return contact;
	}







	public void setContact(String contact) {
		this.contact = contact;
	}







	public String getEmail() {
		return email;
	}







	public void setEmail(String email) {
		this.email = email;
	}







	public String getDescription() {
		return description;
	}







	public void setDescription(String description) {
		this.description = description;
	}







	public Address getAddress() {
		return address;
	}







	public void setAddress(Address address) {
		this.address = address;
	}







	public Set<Faculty> getFaculties() {
		return faculties;
	}

	public void setFaculties(Set<Faculty> faculties) {
		this.faculties = faculties;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}



	public Set<Teacher> getTeachers() {
		return teachers;
	}



	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}	
	
	

	
	
	
	


	
	
	
	

}
