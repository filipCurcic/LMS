package app.dto;

import java.util.Date;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;




public class TitleDto {

	@JacksonXmlProperty(isAttribute = true)
	private Long id;
	private String name;
	private Date DateOfSelection;
	private Date DateOfCessation;
	private TitleTypeDto titleTypeDto;
	private ScientificFieldDto scientificFieldDto;
	private TeacherDto teacherDto;
	
		
	@JacksonXmlProperty(isAttribute = true)
	private int version = 0;
	
	public TitleDto() {
		
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

	public Date getDateOfSelection() {
		return DateOfSelection;
	}

	public void setDateOfSelection(Date dateOfSelection) {
		DateOfSelection = dateOfSelection;
	}

	public Date getDateOfCessation() {
		return DateOfCessation;
	}

	public void setDateOfCessation(Date dateOfCessation) {
		DateOfCessation = dateOfCessation;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public TitleTypeDto getTitleTypeDto() {
		return titleTypeDto;
	}

	public void setTitleTypeDto(TitleTypeDto titleTypeDto) {
		this.titleTypeDto = titleTypeDto;
	}

	public ScientificFieldDto getScientificFieldDto() {
		return scientificFieldDto;
	}

	public void setScientificFieldDto(ScientificFieldDto scientificFieldDto) {
		this.scientificFieldDto = scientificFieldDto;
	}

	public TeacherDto getTeacherDto() {
		return teacherDto;
	}

	public void setTeacherDto(TeacherDto teacherDto) {
		this.teacherDto = teacherDto;
	}
	
	
	
	
	
}
