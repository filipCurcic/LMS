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
	@Column(name="addressId")
	private Long id;
	@NotNull
	private Date year;
	@OneToMany(mappedBy="studyYear")
	private Set<StudentOnYear> studentsOnYear;
	@OneToMany
	private Set<StudyCourse> studyCoures;
	
	public StudyYear(Long id, @NotNull Date year, Set<StudentOnYear> studentsOnYear) {
		this.id = id;
		this.year = year;
		this.studentsOnYear = studentsOnYear;
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
	
	
	
	
}
