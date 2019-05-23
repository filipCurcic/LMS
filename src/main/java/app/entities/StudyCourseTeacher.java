package app.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class StudyCourseTeacher {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private StudyCourse studyCourse;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Teacher teacher;
	
	public StudyCourseTeacher() {}

	public StudyCourseTeacher(Long id, StudyCourse studyCourse, Teacher teacher) {
		super();
		this.id = id;
		this.studyCourse = studyCourse;
		this.teacher = teacher;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StudyCourse getStudyCourse() {
		return studyCourse;
	}

	public void setStudyCourse(StudyCourse studyCourse) {
		this.studyCourse = studyCourse;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	
	
	
	
}
