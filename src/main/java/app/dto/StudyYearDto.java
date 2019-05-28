package app.dto;

import java.util.Collection;
import java.util.Date;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class StudyYearDto {

	@JacksonXmlProperty(isAttribute = true)
	private Long id;
	private Date year;
	private Integer studyYear;
	private Collection<String> studentOnYear;
	private Collection<String> studyCourse;
	
	public StudyYearDto() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public void setStudyYear(Integer studyYear) {
		this.studyYear = studyYear;
	}

	public Date getYear() {
		return year;
	}

	public void setYear(Date year) {
		this.year = year;
	}

	public Integer getStudyYear() {
		return studyYear;
	}

	public Collection<String> getStudentOnYear() {
		return studentOnYear;
	}

	public void setStudentOnYear(Collection<String> studentOnYear) {
		this.studentOnYear = studentOnYear;
	}

	public Collection<String> getStudyCourse() {
		return studyCourse;
	}

	public void setStudyCourse(Collection<String> studyCourse) {
		this.studyCourse = studyCourse;
	}

	
	
	
}
