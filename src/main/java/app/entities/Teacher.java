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
public class Teacher extends RegisteredUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String name;
	@NotNull
	private String biography;
	@NotNull
	private String umcn;
	
	@OneToMany(mappedBy = "teacher")
	private Set<Title> titles;
	
	@OneToMany(mappedBy="teacher")
	private Set<TeacherOnRealization> teachersOnRealization;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private University university;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private StudyCourse studyCourse;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Faculty faculty;
	
	@OneToOne
	@JoinColumn(name="addressId")
	private Address address;
	
	public Teacher() {}

	public Teacher(Long id, String name, String biography, String umcn, Set<Title> titles, Set<TeacherOnRealization> teachersOnRealization) {
		super();
		this.id = id;
		this.biography = biography;
		this.umcn = umcn;
		this.titles = titles;
		this.teachersOnRealization = teachersOnRealization;
		
	}

	
	
	
	public Teacher(String username, String password, String email, String name, String biography, String umcn) {
		super(username, password, email);
		this.biography = biography;
		this.umcn = umcn;
		
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

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public String getUmcn() {
		return umcn;
	}

	public void setUmcn(String umcn) {
		this.umcn = umcn;
	}

	public Set<Title> getTitles() {
		return titles;
	}

	public void setTitles(Set<Title> titles) {
		this.titles = titles;
	}

	public Set<TeacherOnRealization> getTeachersOnRealization() {
		return teachersOnRealization;
	}

	public void setTeachersOnRealization(Set<TeacherOnRealization> teachersOnRealization) {
		this.teachersOnRealization = teachersOnRealization;
	}



}
