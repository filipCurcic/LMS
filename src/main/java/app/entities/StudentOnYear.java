package app.entities;

import java.util.Date;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

public class StudentOnYear {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@ManyToOne(fetch=FetchType.LAZY)
	private String index;
	@NotNull
	private Date enrollmentDate;
	@ManyToOne(fetch = FetchType.LAZY)
	private StudyYear studyYear;
	
	public StudentOnYear(Long id, String index, Date enrollmentDate, StudyYear studyYear) {
		this.id = id;
		this.index = index;
		this.enrollmentDate = enrollmentDate;
		this.studyYear = studyYear;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
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
	
	
	
	
	

}
