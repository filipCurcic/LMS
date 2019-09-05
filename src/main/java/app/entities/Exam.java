package app.entities;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonView;

import app.utils.View.ShowExamRealization;
import app.utils.View.ShowExamTopic;

@Entity
public class Exam {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
//	@Temporal(TemporalType.TIME)
	private Date startTime;
	
//	@Temporal(TemporalType.TIME)
	private Date endTime;
	
	@NotNull
	private Integer points;
	
	@NotNull
	private Integer durationInMinutes;
	
	@ManyToOne(cascade={CascadeType.REMOVE, CascadeType.MERGE})
	private CourseRealization courseRealization;
	
	@JsonView(ShowExamRealization.class)
	@OneToMany(mappedBy="exam")
	private Set<ExamRealization> examRealizations;
	
	@JsonView(ShowExamTopic.class)
	@OneToMany(mappedBy="exam", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<ExamTopic> syllabus;

	@ManyToOne(cascade={CascadeType.REFRESH, CascadeType.MERGE})
	private ExamType examType;
	
	public Exam() {
		
	}


	
	public Exam(Date startTime, Date endTime, Integer points, Integer durationInMinutes,
			CourseRealization courseRealization, ExamType examType, Set<ExamRealization> examRealizations,
			Set<ExamTopic> syllabus) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
		this.points = points;
		this.durationInMinutes = durationInMinutes;
		this.courseRealization = courseRealization;
		this.examType = examType;
		this.examRealizations = examRealizations;
		this.syllabus = syllabus;
	}





	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Integer getDurationInMinutes() {
		return durationInMinutes;
	}

	public void setDurationInMinutes(Integer durationInMinutes) {
		this.durationInMinutes = durationInMinutes;
	}

	public CourseRealization getCourseRealization() {
		return courseRealization;
	}

	public void setCourseRealization(CourseRealization courseRealization) {
		this.courseRealization = courseRealization;
	}


	public Set<ExamRealization> getExamRealizations() {
		return examRealizations;
	}


	public void setExamRealizations(Set<ExamRealization> examRealizations) {
		this.examRealizations = examRealizations;
	}


	public Set<ExamTopic> getSyllabus() {
		return syllabus;
	}


	public void setSyllabus(Set<ExamTopic> syllabus) {
		this.syllabus = syllabus;
	}


	public ExamType getExamType() {
		return examType;
	}


	public void setExamType(ExamType examType) {
		this.examType = examType;
	}
	
	
	
}
