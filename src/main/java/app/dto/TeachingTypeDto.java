package app.dto;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;


public class TeachingTypeDto {

	@JacksonXmlProperty(isAttribute = true)
	private Long id;
	private String name;
	private TeacherOnRealizationDto teacherOnRealizationDto;
	private int version = 0;
	
	public TeachingTypeDto() {
		
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

	public TeacherOnRealizationDto getTeacherOnRealizationDto() {
		return teacherOnRealizationDto;
	}

	public void setTeacherOnRealizationDto(TeacherOnRealizationDto teacherOnRealizationDto) {
		this.teacherOnRealizationDto = teacherOnRealizationDto;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	
	
}
