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

import app.dto.TitleDto;
import app.entities.Title;
import app.mappers.TitleMapper;
import app.services.TitleService;


@CrossOrigin(origins= {"http://localhost:4200"} ) 
@RestController 
@RequestMapping( "/title" ) 
public class TitleController {
	
	@Autowired
	TitleService ts;
	
	@Autowired
	TitleMapper titleMapper;

	@RequestMapping("/all")
	public ResponseEntity<Iterable<TitleDto>> getTitles() {
		List<Title> title = ts.getTitles();
		return ResponseEntity.ok(titleMapper.toDTO(title));
	}

	@RequestMapping(value="/", method=RequestMethod.POST)
	public ResponseEntity<Title> addTitle(@RequestBody Title title) {
		ts.addTitle(title);
		return new ResponseEntity<Title>(title, HttpStatus.OK);
	}


	@RequestMapping("/{id}")
	public ResponseEntity<Title> getOne(@PathVariable Long id) {
		Optional<Title> title = ts.getOne(id);
		if (title.isPresent()) {
			return new ResponseEntity<Title>(title.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Title>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Title> removeTitle(@PathVariable Long id) {
		try {
			ts.removeTitle(id);
		} catch (Exception e) {
			return new ResponseEntity<Title>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Title>(HttpStatus.NO_CONTENT);
	}

}
