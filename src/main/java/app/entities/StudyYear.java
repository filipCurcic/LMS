package app.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class StudyYear {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private Date year;
	@NotNull
	private Integer studyYear; // (1, 2, 3, 4)
	@OneToMany(mappedBy="studyYear")
	private Set<StudentOnYear> studentsOnYear;
	@OneToMany
	private Set<StudyCourse> studyCoures;
	
	public StudyYear() {}

	public StudyYear(Long id, @NotNull Date year, @NotNull Integer studyYear, Set<StudentOnYear> studentsOnYear,
			Set<StudyCourse> studyCoures) {
		super();
		this.id = id;
		this.year = year;
		this.studyYear = studyYear;
		this.studentsOnYear = studentsOnYear;
		this.studyCoures = studyCoures;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getYear() {
		return year;
	}

	public void setYear(Date year) {
		this.year = year;
	}

	public Set<StudentOnYear> getStudentsOnYear() {
		return studentsOnYear;
	}

	public void setStudentsOnYear(Set<StudentOnYear> studentsOnYear) {
		this.studentsOnYear = studentsOnYear;
	}

	public Integer getStudyYear() {
		return studyYear;
	}

	public void setStudyYear(Integer studyYear) {
		this.studyYear = studyYear;
	}

	public Set<StudyCourse> getStudyCoures() {
		return studyCoures;
	}

	public void setStudyCoures(Set<StudyCourse> studyCoures) {
		this.studyCoures = studyCoures;
	}
	
	
	
	
	
	
}
