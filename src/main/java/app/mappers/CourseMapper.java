package app.mappers;

import java.util.ArrayList;
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
			for(StudyYear studyYear: course.getYearsOfStudy()) {
				retVal.getYearsOfStudy().add("/study-year" + studyYear.getId());
			}
			retVal.setSyllabus(new ArrayList<>());
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
		return null;		
	}
	
	public List<CourseDto> toDTO(List<Course> course){
		List<CourseDto > retVal = new ArrayList<CourseDto >();
		for (Course courses: course) {
			retVal.add(toDTO(courses));
		}
		return retVal;
	}

	public List<Course> toEntity(List<CourseDto > courseDto){
		return null;
	}



}
