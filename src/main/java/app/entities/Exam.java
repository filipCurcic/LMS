package app.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
public class Exam {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date startTime;
	
	@NotNull
	private String name;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date endTime;
	@NotNull
	private int points;
	
	private String examTerm;
	
	private int grade;
	
	private int duration;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "check_id", referencedColumnName = "id")
	private Checkin checkin;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private CourseRealization courseRealization;


	public Exam() {}

	public Exam(String name, Date startTime, Date endTime, int points, int duration, String examTerm, int grade) {
		super();
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
		this.points = points;
		this.duration = duration;
		this.grade = grade;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	public String getExamTerm() {
		return examTerm;
	}

	public void setExamTerm(String examTerm) {
		this.examTerm = examTerm;
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

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}


	


	
}
