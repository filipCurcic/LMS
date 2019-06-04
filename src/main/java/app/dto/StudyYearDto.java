package app.dto;

import java.util.Collection;
import java.util.Date;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class StudyYearDto {

	@JacksonXmlProperty(isAttribute = true)
	private Long id;
	private Date startDate;
	private Date endDate;
	private Integer studyYear;
	private Collection<String> studentOnYear;
	private StudyCourseDto studyCourse;
	
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

	
	

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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

	public StudyCourseDto getStudyCourse() {
		return studyCourse;
	}

	public void setStudyCourse(StudyCourseDto studyCourse) {
		this.studyCourse = studyCourse;
	}


	
	
}
