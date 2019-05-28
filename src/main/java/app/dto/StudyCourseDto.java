package app.dto;

import java.util.Collection;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class StudyCourseDto {

	@JacksonXmlProperty(isAttribute = true)
	private Long id;
	private String name;
	private FacultyDto facultyDto;
	private Collection<String> studyCourseTeacher;
	@JacksonXmlProperty(isAttribute = true)
	private int version;
	
	public StudyCourseDto() {
		
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

	public FacultyDto getFacultyDto() {
		return facultyDto;
	}

	public void setFacultyDto(FacultyDto facultyDto) {
		this.facultyDto = facultyDto;
	}

	public Collection<String> getStudyCourseTeacher() {
		return studyCourseTeacher;
	}

	public void setStudyCourseTeacher(Collection<String> studyCourseTeacher) {
		this.studyCourseTeacher = studyCourseTeacher;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	
}
