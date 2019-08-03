package app.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;

import app.utils.View.ShowStudyCourseTeacher;
import app.utils.View.ShowStudyYear;



@Entity
public class StudyCourse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String name;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade= {CascadeType.MERGE, CascadeType.REMOVE})
	private Faculty faculty;
	
	@JsonView(ShowStudyCourseTeacher.class)
	@OneToMany(mappedBy="studyCourse")
	private Set<StudyCourseTeacher> studyCourseTeacher;
	
	@JsonView(ShowStudyYear.class)
	@OneToMany(mappedBy= "studyCourse")
	private Set<StudyYear> studyYear;
	
	
	private String imgPath;
	
	public StudyCourse () {}
	

	public StudyCourse(Long id, @NotNull String name, Faculty faculty, Set<StudyCourseTeacher> studyCourseTeacher) {
		super();
		this.id = id;
		this.name = name;
		this.faculty = faculty;
		this.studyCourseTeacher = studyCourseTeacher;
		
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

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}


	public Set<StudyCourseTeacher> getStudyCourseTeacher() {
		return studyCourseTeacher;
	}


	public void setStudyCourseTeacher(Set<StudyCourseTeacher> studyCourseTeacher) {
		this.studyCourseTeacher = studyCourseTeacher;
	}


	public String getImgPath() {
		return imgPath;
	}


	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}


	public Set<StudyYear> getStudyYear() {
		return studyYear;
	}


	public void setStudyYear(Set<StudyYear> studyYear) {
		this.studyYear = studyYear;
	}
	
	
	
	
	
}
