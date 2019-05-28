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

import com.fasterxml.jackson.annotation.JsonView;

import app.dto.CountryDto;
import app.entities.Country;
import app.mappers.CountryMapper;
import app.services.CountryService;
import app.utils.View.HideOptionalProperties;


@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/country")
public class CountryController {
	
	
	@Autowired
	CountryService countServ;
	
	@Autowired
	CountryMapper countryMapper;
	
	@RequestMapping("/all")
	public ResponseEntity<Iterable<CountryDto>> getCountries(){
		List<Country> country = countServ.getAll();
		return ResponseEntity.ok(countryMapper.toDTO(country));

	}
	
	@RequestMapping("/{id}")
	public CountryDto getCountry(@PathVariable Long id) {
		Country country = countServ.getOne(id);
		return countryMapper.toDTO(country);
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
