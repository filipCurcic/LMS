package app.dto;

import java.util.Date;

public class ExamRegistrationDTO {
	private Long examId;
	private Long courseRealizationId;
	private String courseName;
	private Date startTime;
	private int duration;
	private String examType;
	private int studyYearYear;
	private String studyProgramName;
	
	public ExamRegistrationDTO(Long examId, Long courseRealizationId, String courseName, Date startTime, int duration,
			String examType, int studyYearYear, String studyProgramName) {
		super();
		this.examId = examId;
		this.courseRealizationId = courseRealizationId;
		this.courseName = courseName;
		this.startTime = startTime;
		this.duration = duration;
		this.examType = examType;
		this.studyYearYear = studyYearYear;
		this.studyProgramName = studyProgramName;
	}
	
	public ExamRegistrationDTO() {}

	public Long getExamId() {
		return examId;
	}
	public void setExamId(Long examId) {
		this.examId = examId;
	}
	
	public Long getCourseRealizationId() {
		return courseRealizationId;
	}
	public void setCourseRealizationId(Long courseRealizationId) {
		this.courseRealizationId = courseRealizationId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getStudyYearYear() {
		return studyYearYear;
	}
	public void setStudyYearYear(int studyYearYear) {
		this.studyYearYear = studyYearYear;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getExamType() {
		return examType;
	}
	public void setExamType(String examType) {
		this.examType = examType;
	}
	
	public String getStudyProgramName() {
		return studyProgramName;
	}
	public void setStudyProgramName(String studyProgramName) {
		this.studyProgramName = studyProgramName;
	}
	
}
