package app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.StudyYear;
import app.repositories.CourseRepository;
import app.repositories.StudyYearRepository;

@Service
public class StudyYearService {

	@Autowired
	StudyYearRepository stuYRep;
	
	@Autowired
	StudyYearService studyYearService;
	
	@Autowired
	CourseRepository courseRepository;
	
	public Iterable<StudyYear> getAll(){
		return stuYRep.findAll();
	}
	
	public Optional<StudyYear> getOne(Long id){
		return stuYRep.findById(id);
	}
	
	public Optional<StudyYear> getYearOfStudyById(Long id) {
	    return stuYRep.findById(id);
	    }
	public void addStudyYear(StudyYear stuY) {
		stuYRep.save(stuY);
	}
	
	public void removeStudyYear(Long id) {
		Optional<StudyYear> is = stuYRep.findById(id);
		stuYRep.delete(is.get());
	}
	
//	public ArrayList<Course> getCourse(Long studyYearId) {
//    	return courseRepository.findByStudyYearIdEquals(studyYearId);
//    }
    
	
	public Optional<StudyYear> getNextYearOfStudyByStudyProgram(Long id) {
    	Optional<StudyYear> sy = studyYearService.getYearOfStudyById(id);
    	if(sy.isPresent()) {
    		StudyYear studyYear = sy.get();
    		int year = studyYear.getStudyYear();
    		year = year+1;
    		Optional<StudyYear> nextYearOfStudy = stuYRep.getNextYear(year, studyYear.getStudyCourse().getId());
    		return nextYearOfStudy;
    	}
        return sy;
    }
    
	
}
