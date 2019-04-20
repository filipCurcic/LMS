package app.entities;

import java.util.Set;

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
	
	@OneToMany(mappedBy="faculty")
	private Set<StudyCourse> studyCourse;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private University university;
	
	@OneToOne
	@JoinColumn(name="addressId")
	private Address address;
	
	@OneToMany(mappedBy="faculty")
	private Set<Teacher> teachers;
	
	@Version
	private int version = 0;
	
	public Faculty() {}

	public Faculty(Long id, String name, Set<StudyCourse> studyCourse, University university, Address address, Set<Teacher> teachers,
			int version) {
		this.id = id;
		this.name = name;
		this.studyCourse = studyCourse;
		this.university = university;
		this.address = address;
		this.version = version;
		this.teachers = teachers;
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
