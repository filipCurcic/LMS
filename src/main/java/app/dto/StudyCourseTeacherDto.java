package app.dto;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class StudyCourseTeacherDto {

	@JacksonXmlProperty(isAttribute = true)
	private Long id;
	private StudyCourseDto studyCourseDto;
	private TeacherDto teacherDto;
	
	public StudyCourseTeacherDto() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StudyCourseDto getStudyCourseDto() {
		return studyCourseDto;
	}

	public void setStudyCourseDto(StudyCourseDto studyCourseDto) {
		this.studyCourseDto = studyCourseDto;
	}

	public TeacherDto getTeacherDto() {
		return teacherDto;
	}

	public void setTeacherDto(TeacherDto teacherDto) {
		this.teacherDto = teacherDto;
	}
	
	
	
}
