package app.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonView;

import app.utils.View.ShowCourseAttending;
import app.utils.View.ShowCourseRealization;
import app.utils.View.ShowExam;
import app.utils.View.ShowTeacherOnRealization;

@Entity
public class CourseRealization {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	@JsonView(ShowCourseAttending.class)
	@OneToMany(mappedBy = "courseRealization", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<CourseAttending> courseAttendings;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade= {CascadeType.MERGE, CascadeType.REMOVE})
	private Course course;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade= {CascadeType.MERGE, CascadeType.REMOVE})
	private StudyYear studyYear;
	
	
	@JsonView(ShowTeacherOnRealization.class)
	@OneToMany(mappedBy="courseRealization")
	private Set<TeacherOnRealization> teacherOnRealizations;
	
	
	@JsonView(ShowExam.class)
	@OneToMany(mappedBy = "courseRealization")
	private Set<Exam> exams;
	
	public CourseRealization() {
		
	}

	public CourseRealization(Long id, Date startDate, Date endDate,
			Set<CourseAttending> courseAttendings, Course course, StudyYear studyYear,
			Set<Exam> exams) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.courseAttendings = courseAttendings;
		this.course = course;
		this.studyYear = studyYear;
		this.exams = exams;
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

	public Set<CourseAttending> getCourseAttendings() {
		return courseAttendings;
	}

	public void setCourseAttendings(Set<CourseAttending> courseAttendings) {
		this.courseAttendings = courseAttendings;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}


	public StudyYear getStudyYear() {
		return studyYear;
	}


	public void setStudyYear(StudyYear studyYear) {
		this.studyYear = studyYear;
	}


	public Set<Exam> getExams() {
		return exams;
	}

	public void setExams(Set<Exam> exams) {
		this.exams = exams;
	}








	public Set<TeacherOnRealization> getTeacherOnRealizations() {
		return teacherOnRealizations;
	}








	public void setTeacherOnRealizations(Set<TeacherOnRealization> teacherOnRealizations) {
		this.teacherOnRealizations = teacherOnRealizations;
	}



	
	
	
	
/*
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + ((courseAttendings == null) ? 0 : courseAttendings.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CourseRealization other = (CourseRealization) obj;
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
			return false;
		if (courseAttendings == null) {
			if (other.courseAttendings != null)
				return false;
		} else if (!courseAttendings.equals(other.courseAttendings))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}
	
*/
}
