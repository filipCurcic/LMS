package app.dto;

import java.util.Collection;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;


public class CourseAttendingDto {

	@JacksonXmlProperty(isAttribute = true)
	private Long id;
	private StudentDto student;
	private CourseRealizationDto courseRealization;
	
	public CourseAttendingDto() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StudentDto getStudent() {
		return student;
	}

	public void setStudent(StudentDto student) {
		this.student = student;
	}

	public CourseRealizationDto getCourseRealization() {
		return courseRealization;
	}

	public void setCourseRealization(CourseRealizationDto courseRealization) {
		this.courseRealization = courseRealization;
	}


	
}
