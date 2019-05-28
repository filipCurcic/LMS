package app.dto;

import java.util.Collection;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;



public class CourseDto {

	@JacksonXmlProperty(isAttribute = true)
	private Long id;
	private String name;
	private int espb;
	private boolean mandatory;
	private int numberOfLectures;
	private int numberOfExercises;
	private int otherTypesOfTeachings;
	private int researchWork;
	private int otherClasses;
	private Collection<String> courseRealizations;
	private Collection<String> yearsOfStudy;
	private Collection<String> syllabus;
	private Collection<String> precondition;
	private Collection<String> preconditionFor;
	
	public CourseDto() {
		
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

	public Collection<String> getCourseRealizations() {
		return courseRealizations;
	}

	public void setCourseRealizations(Collection<String> courseRealizations) {
		this.courseRealizations = courseRealizations;
	}

	public Collection<String> getYearsOfStudy() {
		return yearsOfStudy;
	}

	public void setYearsOfStudy(Collection<String> yearsOfStudy) {
		this.yearsOfStudy = yearsOfStudy;
	}

	public Collection<String> getSyllabus() {
		return syllabus;
	}

	public void setSyllabus(Collection<String> syllabus) {
		this.syllabus = syllabus;
	}

	public Collection<String> getPrecondition() {
		return precondition;
	}

	public void setPrecondition(Collection<String> precondition) {
		this.precondition = precondition;
	}

	public Collection<String> getPreconditionFor() {
		return preconditionFor;
	}

	public void setPreconditionFor(Collection<String> preconditionFor) {
		this.preconditionFor = preconditionFor;
	}
	
	
	
}
