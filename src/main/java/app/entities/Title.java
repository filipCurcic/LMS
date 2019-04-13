package app.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;




@Entity	 
public class Title {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private Date DateOfSelection;
	@NotNull
	private Date DateOfCessation;
	
	@OneToMany(mappedBy = "title")
	private Set<ScientificField> fields;
	
	@OneToMany(mappedBy = "title")
	private Set<TitleType> types;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Teacher teacher;
	
	@Version
	private int version = 0;
	
	public Title() {}
	
	public Title(Long id, Date DateOfSelection, Date DateOfCessation, Set<ScientificField> fields, Set<TitleType> types, Teacher teacher) {
		super();
		this.id = id;	
		this.DateOfSelection = DateOfSelection;
		this.DateOfCessation = DateOfCessation;
		this.fields = fields;
		this.types = types;
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

	public Set<ScientificField> getFields() {
		return fields;
	}

	public void setFields(Set<ScientificField> fields) {
		this.fields = fields;
	}

	public Set<TitleType> getTypes() {
		return types;
	}

	public void setTypes(Set<TitleType> types) {
		this.types = types;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	
	

}