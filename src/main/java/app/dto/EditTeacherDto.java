package app.dto;

import app.entities.RegisteredUser;
import app.entities.Teacher;

public class EditTeacherDto {
	private Teacher teacher;
	private RegisteredUser regUser;
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public RegisteredUser getRegUser() {
		return regUser;
	}
	public void setRegUser(RegisteredUser regUser) {
		this.regUser = regUser;
	}
	

}
