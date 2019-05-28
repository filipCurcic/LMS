package app.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class CourseOutcomeDto {

	@JacksonXmlProperty(isAttribute = true)
	private Long id;
	private String description;
	private CourseDto courseDto;
	
	public CourseOutcomeDto() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CourseDto getCourseDto() {
		return courseDto;
	}

	public void setCourseDto(CourseDto courseDto) {
		this.courseDto = courseDto;
	}


	
}
