package app.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class ExamRealization {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private Integer points;
	
	@NotNull
	private String note;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Exam exam;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private StudentOnYear studentOnYear;

	public ExamRealization() {
		super();
	}

	public ExamRealization(Integer points, String note, Exam exam, StudentOnYear studentOnYear) {
		super();
		this.points = points;
		this.note = note;
		this.exam = exam;
		this.studentOnYear = studentOnYear;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public StudentOnYear getStudentOnYear() {
		return studentOnYear;
	}

	public void setStudentOnYear(StudentOnYear studentOnYear) {
		this.studentOnYear = studentOnYear;
	}
	
	
}

