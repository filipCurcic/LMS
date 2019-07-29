package app.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;

import app.utils.View.ShowCheckin;
import app.utils.View.ShowCourseAttending;
import app.utils.View.ShowStudentOnYeear;

@Entity
public class Student{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String lastName;
	
	@NotNull
	private String jmbg;
	
	@NotNull
	private boolean deleted = false;
	
	@Column(length=128)
	private String profilePicturePath;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
	private Address address;
	
	@JsonView(ShowStudentOnYeear.class)
	@OneToMany(mappedBy="student")
	private Set<StudentOnYear> studentOnYear;
	
	@JsonView(ShowCourseAttending.class)
	@OneToMany(mappedBy= "student")
	private Set<CourseAttending> courseAttending;
	
	@JsonView(ShowCheckin.class)
	@OneToMany(mappedBy = "checkedStudent")
	private Set<Checkin> checkins;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private RegisteredUser registeredUser;

	private int studyYear;
	
	public Student() {}

	public Student(Long id, String name, String lastName, String jmbg, String profilePicturePath, boolean deleted, Address address,
			Set<StudentOnYear> studentOnYear, RegisteredUser registeredUser) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.jmbg = jmbg;
		this.profilePicturePath = profilePicturePath;
		this.deleted = deleted;
		this.address = address;
		this.studentOnYear = studentOnYear;
		this.registeredUser = registeredUser;
	}
	
	public Student(Long id, String name, String lastName, String jmbg, String profilePicturePath, Address address) {
		this.id = id;
		this.name = name;
		this.lastName = lastName;
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

	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	
	public boolean deleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
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


	public Set<StudentOnYear> getStudentOnYear() {
		return studentOnYear;
	}

	public void setStudentOnYear(Set<StudentOnYear> studentOnYear) {
		this.studentOnYear = studentOnYear;
	}

	public Set<CourseAttending> getCourseAttending() {
		return courseAttending;
	}

	public void setCourseAttending(Set<CourseAttending> courseAttending) {
		this.courseAttending = courseAttending;
	}



	public RegisteredUser getRegisteredUser() {
		return registeredUser;
	}

	public void setRegisteredUser(RegisteredUser registeredUser) {
		this.registeredUser = registeredUser;
	}

	public int getStudyYear() {
		return studyYear;
	}

	public void setStudyYear(int studyYear) {
		this.studyYear = studyYear;
	}
	
	
	
	

}
