package app.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

@Entity
public class TeacherOnRealization {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private int numberOfClasses;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Teacher teacher;
	
	
	@OneToOne(mappedBy = "teacherOnRealization")
    private TeachingType teachingType;
	
	@Version
	private int version = 0;
	
	public TeacherOnRealization() {}
	
	

	public TeacherOnRealization(@NotNull int numberOfClasses, Teacher teacher, TeachingType teachingType,
			int version) {
		super();
		this.numberOfClasses = numberOfClasses;
		this.teacher = teacher;
		this.teachingType = teachingType;
		this.version = version;
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



	public int getVersion() {
		return version;
	}



	public void setVersion(int version) {
		this.version = version;
	}

	
	
}

