package app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.Country;
import app.repositories.CountryRepository;

@Service
public class CountryService {

	
	@Autowired
	CountryRepository couRep;
	
	public Iterable<Country> getAll() {
		return couRep.findAll();
	}
	
	public Optional<Country> getOne(Long id) {
		return couRep.findById(id);
	}
	
	public void addCountry(Country country) {
		couRep.save(country);
	}
	
	public void removeCountry(Long id) {
		Optional<Country> country = couRep.findById(id);
		if(country.isPresent()) {
			couRep.delete(country.get());
		}
	}
	
	public void edit(Long id, Country country) {
		Optional<Country> coun = couRep.findById(id); 
		if(coun.isPresent()) {
			country.setId(coun.get().getId());
			couRep.save(country);
		}
	}
	
}
