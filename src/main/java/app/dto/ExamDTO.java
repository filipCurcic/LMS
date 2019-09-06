package app.dto;

import java.util.Date;

public class ExamDTO {
	private int grade;
	private String course;
	private int year;
	private String studyProgramName;
	private int points;
	private Date date;
	private int espb;
	
	public ExamDTO(int finalGrade, String courseName, int year, String studyProgramName, int points, Date examDate,
			int espb) {
		super();
		this.grade = finalGrade;
		this.course = courseName;
		this.year = year;
		this.studyProgramName = studyProgramName;
		this.points = points;
		this.date = examDate;
		this.espb= espb;
	}
	
	public ExamDTO() {}

	
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getEspb() {
		return espb;
	}
	public void setEspb(int espb) {
		this.espb = espb;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getStudyProgramName() {
		return studyProgramName;
	}
	public void setStudyProgramName(String studyProgramName) {
		this.studyProgramName = studyProgramName;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public Date getDate() {
		return date;
	}
	public void setExamDate(Date date) {
		this.date = date;
	}
	
		

}
