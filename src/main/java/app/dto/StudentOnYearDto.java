package app.dto;

import java.util.Date;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;


public class StudentOnYearDto {
	
	@JacksonXmlProperty(isAttribute = true)
	private Long id;
	private String indeks;
	private Date enrollmentDate;
	private StudyYearDto studyYearDto;
	private StudentDto studentDto;
	
	public StudentOnYearDto() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIndeks() {
		return indeks;
	}

	public void setIndeks(String indeks) {
		this.indeks = indeks;
	}

	public Date getEnrollmentDate() {
		return enrollmentDate;
	}

	public void setEnrollmentDate(Date enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

	public StudentDto getStudentDto() {
		return studentDto;
	}

	public void setStudentDto(StudentDto studentDto) {
		this.studentDto = studentDto;
	}

	public StudyYearDto getStudyYearDto() {
		return studyYearDto;
	}

	public void setStudyYearDto(StudyYearDto studyYearDto) {
		this.studyYearDto = studyYearDto;
	}
	
	
	
	
	
}
