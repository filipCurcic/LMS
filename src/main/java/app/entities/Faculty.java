package app.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;


@Entity
public class Faculty {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String contact;
	
	@NotNull
	private String email;
	
	@NotNull
	private String description;
	
	
	@OneToMany(mappedBy="faculty")
	private Set<StudyCourse> studyCourse;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	private University university;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Address address;
	
	@OneToMany(mappedBy="faculty")
	private Set<Teacher> teachers;
	
	@Version
	private int version = 0;
	
	public Faculty() {}

	
	public Faculty(@NotNull String name, @NotNull String contact, @NotNull String email, @NotNull String description,
			Set<StudyCourse> studyCourse, University university, Address address, Set<Teacher> teachers, int version) {
		super();
		this.name = name;
		this.contact = contact;
		this.email = email;
		this.description = description;
		this.studyCourse = studyCourse;
		this.university = university;
		this.address = address;
		this.teachers = teachers;
		this.version = version;
	}
	
	
	public Faculty(Long id, String name, String contact, String email,
			String description, University university, int version) {
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.email = email;
		this.description = description;
		this.university = university;
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


	public Set<StudyCourse> getStudyCourse() {
		return studyCourse;
	}

	public void setStudyCourse(Set<StudyCourse> studyCourse) {
		this.studyCourse = studyCourse;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}
	
	
	
	
	
	
	
	
}
