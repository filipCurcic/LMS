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

import app.entities.City;
import app.services.CityService;


@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/city")
public class CityController {

	@Autowired
	CityService cityService;
	
	@RequestMapping("/all")
	public ResponseEntity<Iterable<City>> getCities(){
		return new ResponseEntity<Iterable<City>>(cityService.getCities(), HttpStatus.OK);
	}
	
	@RequestMapping("/{id}")
	public ResponseEntity<City> getCity(@PathVariable Long id) {
		Optional<City> city = cityService.getOne(id);
		if (city.isPresent()) {
			return new ResponseEntity<City>(city.get(), HttpStatus.OK);
		}
		return new ResponseEntity<City>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<City> addCity(@RequestBody City city){
		cityService.addCity(city);
		return new ResponseEntity<City>(city, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<City> deleteCity(@PathVariable Long id){
		try {
			cityService.removeCity(id);
		} catch (Exception e) {
			return new ResponseEntity<City>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<City>(HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<City> editCity(@PathVariable Long id, @RequestBody City city){
		cityService.updateCity(id, city);
		return new ResponseEntity<City>(city, HttpStatus.OK);
	}

}
