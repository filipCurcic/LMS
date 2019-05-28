package app.dto;

import java.util.Collection;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class CourseRealizationDto {
	
	@JacksonXmlProperty(isAttribute = true)
	private Long id;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date startDate;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date endDate;
	private TeacherOnRealizationDto teacherOnRealizationDto;
	private Collection<String> courseAttendings;
	private CourseDto courseDto;
	
	public CourseRealizationDto() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public TeacherOnRealizationDto getTeacherOnRealizationDto() {
		return teacherOnRealizationDto;
	}

	public void setTeacherOnRealizationDto(TeacherOnRealizationDto teacherOnRealizationDto) {
		this.teacherOnRealizationDto = teacherOnRealizationDto;
	}

	public Collection<String> getCourseAttendings() {
		return courseAttendings;
	}

	public void setCourseAttendings(Collection<String> courseAttendings) {
		this.courseAttendings = courseAttendings;
	}

	public CourseDto getCourseDto() {
		return courseDto;
	}

	public void setCourseDto(CourseDto courseDto) {
		this.courseDto = courseDto;
	}
	
	
	
}
