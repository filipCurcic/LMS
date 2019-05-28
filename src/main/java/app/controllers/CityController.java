package app.controllers;

import java.util.Optional;
import java.util.List;

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

import app.dto.CityDto;
import app.dto.CountryDto;
import app.entities.City;
import app.entities.Country;
import app.mappers.CityMapper;
import app.services.CityService;
import app.utils.View.HideOptionalProperties;


@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/city")
public class CityController {

	@Autowired
	CityService cityService;
	
	@Autowired
	CityMapper cityMapper;
	
	
	
	@RequestMapping("/all")
	public ResponseEntity<Iterable<CityDto>> getAll(){
		List<City> city= cityService.getAll();
		return ResponseEntity.ok(cityMapper.toDTO(city));
	}

	
	@RequestMapping("/{id}")
	public CityDto getCity(@PathVariable Long id) {
		City city = cityService.getOne(id);
		return cityMapper.toDTO(city);
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
