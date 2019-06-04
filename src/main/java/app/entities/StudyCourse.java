package app.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;



@Entity
public class StudyCourse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String name;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Faculty faculty;
	
	@OneToMany(mappedBy="studyCourse")
	private Set<StudyCourseTeacher> studyCourseTeacher;
	
	@OneToMany(mappedBy= "studyCoures")
	private Set<StudyYear> studyYear;
	
	@Version
	private int version = 0;
	
	private String imgPath;
	
	public StudyCourse () {}
	

	public StudyCourse(Long id, @NotNull String name, Faculty faculty, Set<StudyCourseTeacher> studyCourseTeacher,
			int version) {
		super();
		this.id = id;
		this.name = name;
		this.faculty = faculty;
		this.studyCourseTeacher = studyCourseTeacher;
		this.version = version;
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


	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
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
