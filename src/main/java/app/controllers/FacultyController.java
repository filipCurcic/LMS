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

import app.dto.FacultyDto;
import app.entities.Faculty;
import app.mappers.FacultyMapper;
import app.services.FacultyService;

@Controller
@RequestMapping("/faculty")
public class FacultyController {
	
	@Autowired
	FacultyService facSer;
	
	@Autowired
	FacultyMapper facultyMapper;
	
	@RequestMapping("/all")
	public ResponseEntity<Iterable<FacultyDto>> getUniversities(){
		List<Faculty> faculty = facSer.getAll();
		return ResponseEntity.ok(facultyMapper.toDTO(faculty));
	}
	
	// Faculties for specific University
	@RequestMapping("/uni/{id}")
	public ResponseEntity<Iterable<FacultyDto>> getFacultiesOnUni(@PathVariable Long id){
		List<Faculty> faculty = facSer.getFacultiesOnUni(id);
		return new ResponseEntity<Iterable<FacultyDto>>(facultyMapper.toDTO(faculty), HttpStatus.OK);
	}
	
	@RequestMapping("/{id}")
	public ResponseEntity<FacultyDto> getFaculty(@PathVariable Long id) {
		Faculty faculty = facSer.getOne(id);
		return new ResponseEntity<FacultyDto>(facultyMapper.toDTO(faculty), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Faculty> addFaculty(@RequestBody Faculty faculty){
		facSer.addFaculty(faculty);
		return new ResponseEntity<Faculty>(faculty, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Faculty> deleteFaculty(@PathVariable Long id){
		try {
			facSer.removeFaculty(id);
		} catch (Exception e) {
			return new ResponseEntity<Faculty>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Faculty>(HttpStatus.NO_CONTENT);
	}

}
