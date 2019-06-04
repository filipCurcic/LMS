package app.mappers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import app.dto.CourseDto;
import app.entities.Course;
import app.entities.CourseOutcome;
import app.entities.CourseRealization;
import app.entities.StudyYear;

@Component
public class CourseMapper implements Mapper<Course, CourseDto>{

	public CourseDto toDTO(Course course) {
		
		if(course == null) {
			return null;
		}
		
		CourseDto retVal = new CourseDto();
			retVal.setId(course.getId());
			retVal.setNumberOfExercises(course.getNumberOfExercises());
			retVal.setEspb(course.getEspb());
			retVal.setName(course.getName());
			retVal.setMandatory(course.isMandatory());
			retVal.setNumberOfLectures(course.getNumberOfLectures());
			retVal.setOtherClasses(course.getOtherClasses());
			retVal.setResearchWork(course.getResearchWork());
			retVal.setOtherTypesOfTeachings(course.getOtherTypesOfTeachings());
			retVal.setCourseRealizations(new ArrayList<>());
			for(CourseRealization courseRealization: course.getCourseRealizations()) {
				retVal.getCourseRealizations().add("/course-realization/" + courseRealization.getId());
			}
			retVal.setYearsOfStudy(new ArrayList<>());
//			for(StudyYear studyYear: course.getYearsOfStudy()) {
//				retVal.getYearsOfStudy().add("/study-year" + studyYear.getId());
//			}
//			retVal.setSyllabus(new ArrayList<>());
			for(CourseOutcome courseoutcome: course.getSyllabus()) {
				retVal.getSyllabus().add("/course-outcome/" + courseoutcome.getId());
			}
			retVal.setPrecondition(new ArrayList<>());
			for(Course cour: course.getPrecondition()) {
				retVal.getPrecondition().add("/course/" + cour.getId());
			}
			retVal.setPreconditionFor(new ArrayList<>());
			for(Course cour1 : course.getPreconditionFor()) {
				retVal.getPreconditionFor().add("/course/" + cour1.getId());
			}
			return retVal;

	}
	
	public Course toEntity(CourseDto courseDto) {
		if(courseDto == null) {
			return null;		
		}
		
		Course course = new Course();
		
		course.setId(courseDto.getId() );
		course.setEspb(courseDto.getEspb());
		course.setMandatory(course.isMandatory());
		course.setName(courseDto.getName());
		course.setNumberOfExercises(courseDto.getNumberOfExercises());
		course.setNumberOfLectures(courseDto.getNumberOfLectures());
		course.setOtherClasses(courseDto.getOtherClasses());
		course.setOtherTypesOfTeachings(courseDto.getOtherTypesOfTeachings());
		course.setResearchWork(courseDto.getResearchWork());
		return course;
	}
	
	public List<CourseDto> toDTO(List<Course> course){
		
		if(course == null) {
			return null;
		}
		
		List<CourseDto > retVal = new ArrayList<CourseDto >();
		for (Course courses: course) {
			retVal.add(toDTO(courses));
		}
		return retVal;
	}

	public Collection<Course> toEntity(Collection<CourseDto > courseDto){
		if(courseDto == null) {
			return null;
		}
		
		Collection<Course> course = new ArrayList<Course>(courseDto.size());
		for(CourseDto cDto: courseDto) {
			course.add(toEntity(cDto));
		}
		
		return course;
	}



}
