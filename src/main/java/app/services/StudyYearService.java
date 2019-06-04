package app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.StudyYear;
import app.repositories.StudyYearRepository;

@Service
public class StudyYearService {

	@Autowired
	StudyYearRepository stuYRep;
	
	
	public List<StudyYear> getAll(){
		return stuYRep.findAll();
	}
	
	public StudyYear getOne(Long id){
		return stuYRep.findById(id).orElse(null);
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
	
	/*public Optional<StudyYear> getNextYearOfStudyByStudyProgram(Long id) {
    	Optional<StudyYear> sy = stuYRep.get
    	if(sy.isPresent()) {
    		StudyYear studyYear = sy.get();
    		int year = studyYear.getStudyYear();
    		year = year+1;
    		Optional<StudyYear> nextYearOfStudy = stuYRep.getNextYear(year, studyYear.getStudyCoures().getId());
    		return nextYearOfStudy;
    	}
        return sy;
    }
    */
	
}
