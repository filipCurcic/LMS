package app.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.entities.StudyYear;
import app.services.StudyYearService;

@Controller
@RequestMapping("/studyYear")
public class StudyYearController {
	
	@Autowired
	StudyYearService studyYearSer;
	
	@RequestMapping("/all")
	public ResponseEntity<Iterable<StudyYear>> getUniversities(){
		return new ResponseEntity<Iterable<StudyYear>>(studyYearSer.getAll(), HttpStatus.OK);
	}
	
	@RequestMapping("/{id}")
	public ResponseEntity<StudyYear> getStudyYear(@PathVariable Long id) {
		Optional<StudyYear> uni = studyYearSer.getOne(id);
		if (uni.isPresent()) {
			return new ResponseEntity<StudyYear>(uni.get(), HttpStatus.OK);
		}
		return new ResponseEntity<StudyYear>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<StudyYear> addStudyYear(@RequestBody StudyYear studyYear){
		studyYearSer.addStudyYear(studyYear);
		return new ResponseEntity<StudyYear>(studyYear, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<StudyYear> deleteStudyYear(@PathVariable Long id){
		try {
			studyYearSer.removeStudyYear(id);
		} catch (Exception e) {
			return new ResponseEntity<StudyYear>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<StudyYear>(HttpStatus.NO_CONTENT);
	}

}
