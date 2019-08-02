package app.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class ElectiveCourseAttendance {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(cascade=CascadeType.ALL)
	private Student student;

	@ManyToOne(cascade=CascadeType.ALL)
	private CourseRealization courseRealization;

	public ElectiveCourseAttendance() {
		
	}

	public ElectiveCourseAttendance(Student student, CourseRealization courseRealization) {
		this.student = student;
		this.courseRealization = courseRealization;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public CourseRealization getCourseRealization() {
		return courseRealization;
	}

	public void setCourseRealization(CourseRealization courseRealization) {
		this.courseRealization = courseRealization;
	}
	
	
}
