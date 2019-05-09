package app.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Student extends RegisteredUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String jmbg;
	
	@OneToOne
	@JoinColumn(name="addressId")
	private Address address;
	
	@OneToMany(mappedBy="student")
	private Set<StudentOnYear> studentYears;
	
	public Student() {}

	public Student(Long id, String name, String jmbg, Address address,
			Set<StudentOnYear> studentYears) {
		this.id = id;
		this.name = name;
		this.jmbg = jmbg;
		this.address = address;
		this.studentYears = studentYears;
	}
	
	public Student(String username, String password, String email, Long id, String name, String jmbg, Address address) {
		super(username, password, email);
		this.id = id;
		this.name = name;
		this.jmbg = jmbg;
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
	
	
	
	

}
