package app.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class CourseAttending {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer grade;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Student student;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private CourseRealization courseRealization;
	
	public CourseAttending() {}

	
	public CourseAttending(Long id, Student student, CourseRealization courseRealization) {
		super();
		this.id = id;
		this.student = student;
		this.courseRealization = courseRealization;
	}

	public Long getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseRealization == null) ? 0 : courseRealization.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CourseAttending other = (CourseAttending) obj;
		if (courseRealization == null) {
			if (other.courseRealization != null)
				return false;
		} else if (!courseRealization.equals(other.courseRealization))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}
	
	


	public Integer getGrade() {
		return grade;
	}


	public void setGrade(Integer grade) {
		this.grade = grade;
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
