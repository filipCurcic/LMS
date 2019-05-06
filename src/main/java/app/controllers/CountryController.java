package app.controllers;

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

import app.entities.Country;
import app.services.CountryService;


@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/country")
public class CountryController {
	
	
	@Autowired
	CountryService countServ;
	
	@RequestMapping("/all")
	public ResponseEntity<Iterable<Country>> getCountries(){
		return new ResponseEntity<Iterable<Country>>(countServ.getAll(), HttpStatus.OK);
	}
	
	@RequestMapping("/{id}")
	public ResponseEntity<Country> getCountry(@PathVariable Long id) {
		Optional<Country> count = countServ.getOne(id);
		if (count.isPresent()) {
			return new ResponseEntity<Country>(count.get(), HttpStatus.OK);
		}
		return new ResponseEntity<Country>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Country> addCountry(@RequestBody Country country){
		countServ.addCountry(country);
		return new ResponseEntity<Country>(country, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Country> deleteCountry(@PathVariable Long id){
		try {
			countServ.removeCountry(id);
		} catch (Exception e) {
			return new ResponseEntity<Country>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Country>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Country> editCountry(@PathVariable Long id, @RequestBody Country country){
		countServ.edit(id, country);
		return new ResponseEntity<Country>(country, HttpStatus.OK);
	}


}
