package app.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Checkin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Student checkedStudent;
	
	@OneToOne(mappedBy = "checkin", cascade = CascadeType.ALL)
	private Exam exam;

	public Checkin () {}
	
	public Checkin(Long id, Student checkedStudent) {
		super();
		this.id = id;
		this.checkedStudent = checkedStudent;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Student getCheckedStudent() {
		return checkedStudent;
	}

	public void setCheckedStudent(Student checkedStudent) {
		this.checkedStudent = checkedStudent;
	}
	
	
	
	

}
