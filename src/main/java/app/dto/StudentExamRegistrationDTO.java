package app.dto;

public class StudentExamRegistrationDTO {
	private String firstName, lastName, indeks;
	private Long studentId, courseRealizationId, examRealizationId, courseAttendanceId, studentOnYearId;
	private int test1, test2, attendance, finalExam, grade;
	
	
	public StudentExamRegistrationDTO(String firstName, String lastName, String indeks, Long studentId,
			Long courseRealizationId, Long examRealizationId, Long courseAttendanceId, Long studentOnYearId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.indeks= indeks;
		this.studentId = studentId;
		this.courseRealizationId = courseRealizationId;
		this.examRealizationId = examRealizationId;
		this.courseAttendanceId = courseAttendanceId;
		this.studentOnYearId = studentOnYearId;
	}
	public StudentExamRegistrationDTO() {}
	@Override
	public String toString() {
		return "StudentExamRegistrationDTO [firstName=" + firstName + ", lastName=" + lastName + ", indeks="
				+ indeks+ ", studentId=" + studentId + ", courseRealizationId=" + courseRealizationId
				+ ", examRealizationId=" + examRealizationId + ", courseAttendanceId=" + courseAttendanceId
				+ ", studentOnYearId=" + studentOnYearId + ", test1=" + test1 + ", test2=" + test2 + ", attendance="
				+ attendance + ", finalExam=" + finalExam + ", grade=" + grade + "]";
	}

	
	public int getTest1() {
		return test1;
	}
	public void setTest1(int test1) {
		this.test1 = test1;
	}
	public int getTest2() {
		return test2;
	}
	public void setTest2(int test2) {
		this.test2 = test2;
	}
	public int getAttendance() {
		return attendance;
	}
	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}
	public int getFinalExam() {
		return finalExam;
	}
	public void setFinalExam(int finalExam) {
		this.finalExam = finalExam;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public String getIndeks() {
		return indeks;
	}
	public void setIndeks(String indeks) {
		this.indeks = indeks;
	}
	public Long getCourseRealizationId() {
		return courseRealizationId;
	}
	public void setCourseRealizationId(Long courseRealizationId) {
		this.courseRealizationId = courseRealizationId;
	}
	public Long getCourseAttendanceId() {
		return courseAttendanceId;
	}
	public void setCourseAttendanceId(Long courseAttendanceId) {
		this.courseAttendanceId = courseAttendanceId;
	}
	public Long getStudentOnYearId() {
		return studentOnYearId;
	}
	public void setStudentOnYearId(Long studentOnYearId) {
		this.studentOnYearId = studentOnYearId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	
	public Long getExamRealizationId() {
		return examRealizationId;
	}
	public void setExamRealizationId(Long examRealizationId) {
		this.examRealizationId = examRealizationId;
	}
	
	
	
	
}
