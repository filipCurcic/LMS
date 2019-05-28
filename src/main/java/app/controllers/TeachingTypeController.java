package app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.dto.TeachingTypeDto;
import app.entities.TeachingType;
import app.mappers.TeachingTypeMapper;
import app.services.TeachingTypeService;

@CrossOrigin(origins= {"http://localhost:4200"} ) 
@RestController 
@RequestMapping( "/teaching-type" ) 
public class TeachingTypeController {
	
	@Autowired
	TeachingTypeService ts;
	
	@Autowired
	TeachingTypeMapper teachingTypeMapper;

	@RequestMapping("/all")
	public ResponseEntity<Iterable<TeachingTypeDto>> getTeachers() {
		List<TeachingType> teachingType = ts.getTeachingTypes();
		return ResponseEntity.ok(teachingTypeMapper.toDTO(teachingType));
	}

	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ResponseEntity<TeachingType> addTeachingType(@RequestBody TeachingType teachingType) {
		ts.addTeachingType(teachingType);
		return new ResponseEntity<TeachingType>(teachingType, HttpStatus.OK);
	}


	@RequestMapping("/{id}")
	public TeachingTypeDto getOne(@PathVariable Long id) {
		TeachingType teachingType = ts.getOne(id);
		return teachingTypeMapper.toDTO(teachingType);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<TeachingType> removeTeachingType(@PathVariable Long id) {
		try {
			ts.removeTeachingType(id);
		} catch (Exception e) {
			return new ResponseEntity<TeachingType>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<TeachingType>(HttpStatus.NO_CONTENT);
	}

}
