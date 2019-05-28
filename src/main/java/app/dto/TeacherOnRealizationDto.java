package app.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class TeacherOnRealizationDto {
	
	@JacksonXmlProperty(isAttribute = true)
	private Long id;
	private int numberOfClasses;
	@JacksonXmlProperty(isAttribute = true)
	private int version = 0;
	private TeacherDto teacherDto;
	private TeachingTypeDto teachingTypeDto;
	
	public TeacherOnRealizationDto() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumberOfClasses() {
		return numberOfClasses;
	}

	public void setNumberOfClasses(int numberOfClasses) {
		this.numberOfClasses = numberOfClasses;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public TeacherDto getTeacherDto() {
		return teacherDto;
	}

	public void setTeacherDto(TeacherDto teacherDto) {
		this.teacherDto = teacherDto;
	}

	public TeachingTypeDto getTeachingTypeDto() {
		return teachingTypeDto;
	}

	public void setTeachingTypeDto(TeachingTypeDto teachingTypeDto) {
		this.teachingTypeDto = teachingTypeDto;
	}
	
	
	
	
}