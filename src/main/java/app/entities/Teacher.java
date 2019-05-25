package app.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String name;
	@NotNull
	private String biography;
	@NotNull
	private String umcn;
	
	@Column(length=128)
	private String profilePicturePath;
	
	
	@OneToMany(mappedBy = "teacher")
	private Set<Title> titles;
	
	@OneToMany(mappedBy="teacher")
	private Set<TeacherOnRealization> teachersOnRealization;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private University university;
	
	// Middle table with StudyCourse
	@OneToMany(mappedBy="teacher")
	private Set<StudyCourseTeacher> studyCourseTeacher;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Faculty faculty;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Address address;
	
	@ManyToOne
	private RegisteredUser registeredUser;
	
	
	public Teacher() {}

	public Teacher(Long id, @NotNull String name, @NotNull String biography, @NotNull String umcn,
			String profilePicturePath, Set<Title> titles, Set<TeacherOnRealization> teachersOnRealization,
			University university, Set<StudyCourseTeacher> studyCourseTeacher, Faculty faculty, Address address,
			RegisteredUser registeredUser) {
		super();
		this.id = id;
		this.name = name;
		this.biography = biography;
		this.umcn = umcn;
		this.profilePicturePath = profilePicturePath;
		this.titles = titles;
		this.teachersOnRealization = teachersOnRealization;
		this.university = university;
		this.studyCourseTeacher = studyCourseTeacher;
		this.faculty = faculty;
		this.address = address;
		this.registeredUser = registeredUser;
	}






	public Teacher(String name, String biography, String umcn) {
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
	 

	public String getProfilePicturePath() {
		return profilePicturePath;
	}

	public void setProfilePicturePath(String profilePicturePath) {
		this.profilePicturePath = profilePicturePath;
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

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public RegisteredUser getRegisteredUser() {
		return registeredUser;
	}

	public void setRegisteredUser(RegisteredUser registeredUser) {
		this.registeredUser = registeredUser;
	}
	
	



}
