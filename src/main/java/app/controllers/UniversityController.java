package app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.dto.UniversityDto;
import app.entities.University;
import app.mappers.UniversityMapper;
import app.services.UniversityService;

@Controller
@RequestMapping("/university")
public class UniversityController {
	
	@Autowired
	UniversityService uniSer;
	
	@Autowired
	UniversityMapper universityMapper;
	
	@RequestMapping("/all")
	public ResponseEntity<Iterable<UniversityDto>> getUniversities(){
		List<University> university = uniSer.getAll();
		return ResponseEntity.ok(universityMapper.toDTO(university));
	}
	
	@RequestMapping("/{id}")
	public ResponseEntity<UniversityDto> getUniversity(@PathVariable Long id) {
		University university = uniSer.getOne(id);
		return new ResponseEntity<UniversityDto>(universityMapper.toDTO(university), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<University> addUniversity(@RequestBody University university){
		uniSer.addUniversity(university);
		return new ResponseEntity<University>(university, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<University> deleteUniversity(@PathVariable Long id){
		try {
			uniSer.removeUniversity(id);
		} catch (Exception e) {
			return new ResponseEntity<University>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<University>(HttpStatus.NO_CONTENT);
	}
	
	
}
