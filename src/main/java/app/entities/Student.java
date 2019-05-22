package app.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Student{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String jmbg;
	
	@Column(length=128)
	private String profilePicturePath;
	
	@OneToOne
	@JoinColumn(name="addressId")
	private Address address;
	
	@OneToMany(mappedBy="student")
	private Set<StudentOnYear> studentYears;
	
	@ManyToOne
	private RegisteredUser registeredUser;
	
	public Student() {}

	public Student(Long id, String name, String jmbg, String profilePicturePath, Address address,
			Set<StudentOnYear> studentYears, RegisteredUser registeredUser) {
		this.id = id;
		this.name = name;
		this.jmbg = jmbg;
		this.profilePicturePath = profilePicturePath;
		this.address = address;
		this.studentYears = studentYears;
		this.registeredUser = registeredUser;
	}
	
	public Student(Long id, String name, String jmbg, String profilePicturePath, Address address) {
		this.id = id;
		this.name = name;
		this.jmbg = jmbg;
		this.profilePicturePath = profilePicturePath;
		this.address = address;
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

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getProfilePicturePath() {
		return profilePicturePath;
	}

	public void setProfilePicturePath(String profilePicturePath) {
		this.profilePicturePath = profilePicturePath;
	}

	public Set<StudentOnYear> getStudentYears() {
		return studentYears;
	}

	public void setStudentYears(Set<StudentOnYear> studentYears) {
		this.studentYears = studentYears;
	}

	public RegisteredUser getRegisteredUser() {
		return registeredUser;
	}

	public void setRegisteredUser(RegisteredUser registeredUser) {
		this.registeredUser = registeredUser;
	}
	
	
	
	

}
