package app.entities;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;




@Entity	 
public class Title {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="titleId")
	private Long id;
	
	@NotNull
	private Date DateOfSelection;
	@NotNull
	private Date DateOfCessation;
	
	@OneToOne(mappedBy = "title")
    private TitleType titleType;
	
	@OneToOne(mappedBy = "title")
    private ScientificField scientificField;
	

	
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Teacher teacher;
	
	@Version
	private int version = 0;
	
	public Title() {}
	
	public Title(Long id, Date DateOfSelection, Date DateOfCessation, ScientificField scientificField, TitleType titleType, Teacher teacher) {
		super();
		this.id = id;	
		this.DateOfSelection = DateOfSelection;
		this.DateOfCessation = DateOfCessation;
		this.scientificField = scientificField;
		this.titleType = titleType;
		this.teacher = teacher;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Date getDateOfSelection() {
		return DateOfSelection;
	}

	public void setDateOfSelection(Date dateOfSelection) {
		DateOfSelection = dateOfSelection;
	}

	public Date getDateOfCessation() {
		return DateOfCessation;
	}

	public void setDateOfCessation(Date dateOfCessation) {
		DateOfCessation = dateOfCessation;
	}

	

	public TitleType getTitleType() {
		return titleType;
	}

	public void setTitleType(TitleType titleType) {
		this.titleType = titleType;
	}

	public ScientificField getScientificField() {
		return scientificField;
	}

	public void setScientificField(ScientificField scientificField) {
		this.scientificField = scientificField;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	
	

}