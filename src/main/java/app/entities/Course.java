package app.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(max = 50)
	@NotNull
	private String name;
	@NotNull
	private int espb;
	//@NotNull
	private boolean mandatory = false; 
	private int numberOfLectures;
	private int numberOfExercises;
	private int otherTypesOfTeachings;
	private int researchWork;
	private int otherClasses;
	
	@OneToMany(mappedBy = "course", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<CourseRealization> courseRealizations;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private StudyYear yearsOfStudy;
	
	@OneToMany(mappedBy = "course" ,fetch = FetchType.LAZY)
	private Set<CourseOutcome> syllabus;
	
	@ManyToMany
	private Set<Course> precondition;
	
	@ManyToMany(mappedBy="precondition")
	private Set<Course> preconditionFor;
	
	
	public Course() {}

	public Course(Long id, @Size(max = 50) @NotNull String name, @NotNull int espb, boolean mandatory,
			int numberOfLectures, int numberOfExercises, int otherTypesOfTeachings, int researchWork, int otherClasses,
			Set<CourseRealization> courseRealizations, StudyYear yearsOfStudy, Set<CourseOutcome> syllabus,
			Set<Course> precondition, Set<Course> preconditionFor) {
		super();
		this.id = id;
		this.name = name;
		this.espb = espb;
		this.mandatory = mandatory;
		this.numberOfLectures = numberOfLectures;
		this.numberOfExercises = numberOfExercises;
		this.otherTypesOfTeachings = otherTypesOfTeachings;
		this.researchWork = researchWork;
		this.otherClasses = otherClasses;
		this.courseRealizations = courseRealizations;
		this.yearsOfStudy = yearsOfStudy;
		this.syllabus = syllabus;
		this.precondition = precondition;
		this.preconditionFor = preconditionFor;
	}





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseRealizations == null) ? 0 : courseRealizations.hashCode());
		result = prime * result + espb;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (mandatory ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + numberOfExercises;
		result = prime * result + numberOfLectures;
		result = prime * result + otherClasses;
		result = prime * result + otherTypesOfTeachings;
		result = prime * result + researchWork;
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
		Course other = (Course) obj;
		if (courseRealizations == null) {
			if (other.courseRealizations != null)
				return false;
		} else if (!courseRealizations.equals(other.courseRealizations))
			return false;
		if (espb != other.espb)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mandatory != other.mandatory)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (numberOfExercises != other.numberOfExercises)
			return false;
		if (numberOfLectures != other.numberOfLectures)
			return false;
		if (otherClasses != other.otherClasses)
			return false;
		if (otherTypesOfTeachings != other.otherTypesOfTeachings)
			return false;
		if (researchWork != other.researchWork)
			return false;
		return true;
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



	public int getEspb() {
		return espb;
	}



	public void setEspb(int espb) {
		this.espb = espb;
	}



	public boolean isMandatory() {
		return mandatory;
	}



	public void setMandatory(boolean mandatory) {
		this.mandatory = mandatory;
	}



	public int getNumberOfLectures() {
		return numberOfLectures;
	}



	public void setNumberOfLectures(int numberOfLectures) {
		this.numberOfLectures = numberOfLectures;
	}



	public int getNumberOfExercises() {
		return numberOfExercises;
	}



	public void setNumberOfExercises(int numberOfExercises) {
		this.numberOfExercises = numberOfExercises;
	}



	public int getOtherTypesOfTeachings() {
		return otherTypesOfTeachings;
	}



	public void setOtherTypesOfTeachings(int otherTypesOfTeachings) {
		this.otherTypesOfTeachings = otherTypesOfTeachings;
	}



	public int getResearchWork() {
		return researchWork;
	}



	public void setResearchWork(int researchWork) {
		this.researchWork = researchWork;
	}



	public int getOtherClasses() {
		return otherClasses;
	}



	public void setOtherClasses(int otherClasses) {
		this.otherClasses = otherClasses;
	}



	public Set<CourseRealization> getCourseRealizations() {
		return courseRealizations;
	}



	public void setCourseRealizations(Set<CourseRealization> courseRealizations) {
		this.courseRealizations = courseRealizations;
	}


	public StudyYear getYearsOfStudy() {
		return yearsOfStudy;
	}

	public void setYearsOfStudy(StudyYear yearsOfStudy) {
		this.yearsOfStudy = yearsOfStudy;
	}

	public Set<CourseOutcome> getSyllabus() {
		return syllabus;
	}



	public void setSyllabus(Set<CourseOutcome> syllabus) {
		this.syllabus = syllabus;
	}



	public Set<Course> getPrecondition() {
		return precondition;
	}



	public void setPrecondition(Set<Course> precondition) {
		this.precondition = precondition;
	}


	public Set<Course> getPreconditionFor() {
		return preconditionFor;
	}


	public void setPreconditionFor(Set<Course> preconditionFor) {
		this.preconditionFor = preconditionFor;
	}
	
	
	
	
	

}
