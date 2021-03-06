package app.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;



@Entity	 
public class Title {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String name;
	
	@NotNull
	private Date DateOfSelection;
	@NotNull
	private Date DateOfCessation;
	
	@ManyToOne(cascade=CascadeType.ALL)
    private TitleType titleType;
	
	@ManyToOne(fetch = FetchType.LAZY)
    private ScientificField scientificField;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Teacher teacher;
	
	public Title() {}

	public Title(Long id, @NotNull String name, @NotNull Date dateOfSelection, @NotNull Date dateOfCessation,
			TitleType titleType, ScientificField scientificField, Teacher teacher) {
		super();
		this.id = id;
		this.name = name;
		DateOfSelection = dateOfSelection;
		DateOfCessation = dateOfCessation;
		this.titleType = titleType;
		this.scientificField = scientificField;
		this.teacher = teacher;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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