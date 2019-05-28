package app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.dto.StudyYearDto;
import app.entities.StudyYear;
import app.mappers.StudyYearMapper;
import app.services.StudyYearService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/study-year")
public class StudyYearController {
	
	@Autowired
	StudyYearService studyYearSer;
	
	@Autowired
	StudyYearMapper studyYearMapper;
	
	
	@RequestMapping("/all")
	public ResponseEntity<Iterable<StudyYearDto>> getStudyYears(){
		List<StudyYear> studyYear = studyYearSer.getAll();
		return ResponseEntity.ok(studyYearMapper.toDTO(studyYear));
	}
	
	@RequestMapping("/{id}")
	public StudyYearDto getStudyYear(@PathVariable Long id) {
		StudyYear uni = studyYearSer.getOne(id);
		return studyYearMapper.toDTO(uni);
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
