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

import com.fasterxml.jackson.annotation.JsonView;

import app.entities.City;
import app.services.CityService;
import app.utils.View.HideOptionalProperties;


@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/city")
public class CityController {

	@Autowired
	CityService cityService;
	
	@JsonView(HideOptionalProperties.class)
    @RequestMapping("/all")
	public ResponseEntity<Iterable<City>> getAll(){
		return new ResponseEntity<Iterable<City>>(cityService.getAll(), HttpStatus.OK);
	}

	
	@JsonView(HideOptionalProperties.class)
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<City> getCityById(@PathVariable Long id) {
        Optional<City> city = cityService.getOne(id);
        if(city.isPresent()) {
            return new ResponseEntity<City>(city.get(), HttpStatus.OK);
        }
        return new ResponseEntity<City>(HttpStatus.NOT_FOUND);
    }

	@RequestMapping(value="/country/{countryId}", method=RequestMethod.GET)
    public ResponseEntity<Iterable<Optional<City>>> getCityByCountry(@PathVariable Long countryId) {
        return new ResponseEntity<Iterable<Optional<City>>>(cityService.getCityByCountry(countryId), HttpStatus.OK);
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
		return new ResponseEntity<City>(city, HttpStatus.CREATED);
	}

}
