package app.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class StudyYear {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private Date startDate;
	@NotNull
	private Date endDate;
	@NotNull
	private Integer studyYear; // (1, 2, 3, 4)
	
	@OneToMany(mappedBy="studyYear")
	private Set<StudentOnYear> studentsOnYear;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private StudyCourse studyCourse;
	
	@OneToMany(mappedBy="yearsOfStudy")
	private Set<Course> courses;
	
	public StudyYear() {}

	public StudyYear(Long id,  @NotNull Integer studyYear, Set<StudentOnYear> studentsOnYear,
			StudyCourse studyCourse) {
		super();
		this.id = id;
		this.studyYear = studyYear;
		this.studentsOnYear = studentsOnYear;
		this.studyCourse = studyCourse;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public Set<StudentOnYear> getStudentsOnYear() {
		return studentsOnYear;
	}

	public void setStudentsOnYear(Set<StudentOnYear> studentsOnYear) {
		this.studentsOnYear = studentsOnYear;
	}

	public Integer getStudyYear() {
		return studyYear;
	}

	public void setStudyYear(Integer studyYear) {
		this.studyYear = studyYear;
	}

	public StudyCourse getStudyCourse() {
		return studyCourse;
	}

	public void setStudyCourse(StudyCourse studyCourse) {
		this.studyCourse = studyCourse;
	}


	
	
	
	
	
}
