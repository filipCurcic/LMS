package app.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class StudentOnYear {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String indeks;
	@NotNull
	private Date enrollmentDate;
	@ManyToOne(cascade= {CascadeType.MERGE, CascadeType.REFRESH})
	private StudyYear studyYear;
	@ManyToOne(cascade= {CascadeType.MERGE, CascadeType.REFRESH})
	private Student student;
	
	public StudentOnYear() {}

	public StudentOnYear(Long id, String indeks, Date enrollmentDate, StudyYear studyYear,
			Student student) {
		this.id = id;
		this.indeks = indeks;
		this.enrollmentDate = enrollmentDate;
		this.studyYear = studyYear;
		this.student = student;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String geIndeks() {
		return indeks;
	}

	public void setIndex(String indeks) {
		this.indeks = indeks;
	}

	public Date getEnrollmentDate() {
		return enrollmentDate;
	}

	public void setEnrollmentDate(Date enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

	public StudyYear getStudyYear() {
		return studyYear;
	}

	public void setStudyYear(StudyYear studyYear) {
		this.studyYear = studyYear;
	}

	public String getIndeks() {
		return indeks;
	}

	public void setIndeks(String indeks) {
		this.indeks = indeks;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	
	
	
	

}
