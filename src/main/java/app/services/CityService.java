package app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.City;
import app.entities.Country;
import app.repositories.CityRepository;

@Service
public class CityService {

	@Autowired
	CityRepository cityRep;
	
	@Autowired
	CountryService countryService;

	public List<City> getAll() {
		return cityRep.findAll();
	}
	
	public City getOne(Long id) {
		return cityRep.findById(id).orElse(null);
	}
	
	public Iterable<Optional<City>> getCityByCountry(Long countryId) {
		return cityRep.getAllByCountry(countryId);
	}
		
	
	public void addCity(City city) {
		cityRep.save(city);
	}
	
	public void removeCity(Long id) {
		Optional<City> city = cityRep.findById(id);
		if(city.isPresent()) {
			cityRep.delete(city.get());
		}
	}
	
	public void updateCity(Long id, City city) {
		Optional<City> c = cityRep.findById(id);
		if(c.isPresent()) {
			city.setId(c.get().getId());
			cityRep.save(city);
		}
	}

}
