package app.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class TeacherOnRealization {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private int numberOfClasses;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE})
	private Teacher teacher;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE})
	private CourseRealization courseRealization;

	
	@OneToOne(mappedBy = "teacherOnRealization")
    private TeachingType teachingType;
	
	
	public TeacherOnRealization() {}
	
	

	public TeacherOnRealization(@NotNull int numberOfClasses, Teacher teacher, TeachingType teachingType) {
		super();
		this.numberOfClasses = numberOfClasses;
		this.teacher = teacher;
		this.teachingType = teachingType;
		
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public int getNumberOfClasses() {
		return numberOfClasses;
	}



	public void setNumberOfClasses(int numberOfClasses) {
		this.numberOfClasses = numberOfClasses;
	}



	public Teacher getTeacher() {
		return teacher;
	}



	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}



	public TeachingType getTeachingType() {
		return teachingType;
	}



	public void setTeachingType(TeachingType teachingType) {
		this.teachingType = teachingType;
	}



	public CourseRealization getCourseRealization() {
		return courseRealization;
	}



	public void setCourseRealization(CourseRealization courseRealization) {
		this.courseRealization = courseRealization;
	}
	
	
	
}

