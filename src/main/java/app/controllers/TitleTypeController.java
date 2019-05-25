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

import app.dto.TitleTypeDto;
import app.entities.TitleType;
import app.mappers.TitleTypeMapper;
import app.services.TitleTypeService;


@CrossOrigin(origins= {"http://localhost:4200"} ) 
@RestController 
@RequestMapping( "/titletype" ) 
public class TitleTypeController {
	
	@Autowired
	TitleTypeService ts;
	
	@Autowired
	TitleTypeMapper titleTypeMapper;

	@RequestMapping("/all")
	public ResponseEntity<Iterable<TitleTypeDto>> getCountries(){
		List<TitleType> titleType= ts.getAll();
		return ResponseEntity.ok(titleTypeMapper.toDTO(titleType));
	}

	@RequestMapping(value="/", method=RequestMethod.POST)
	public ResponseEntity<TitleType> addTitleType(@RequestBody TitleType titleType) {
		ts.addTitleType(titleType);
		return new ResponseEntity<TitleType>(titleType, HttpStatus.OK);
	}


	@RequestMapping("/{id}")
	public ResponseEntity<TitleType> getOne(@PathVariable Long id) {
		Optional<TitleType> titleType = ts.getOne(id);
		if (titleType.isPresent()) {
			return new ResponseEntity<TitleType>(titleType.get(), HttpStatus.OK);
		}
		return new ResponseEntity<TitleType>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<TitleType> removeTitleType(@PathVariable Long id) {
		try {
			ts.removeTitleType(id);
		} catch (Exception e) {
			return new ResponseEntity<TitleType>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<TitleType>(HttpStatus.NO_CONTENT);
	}

}
