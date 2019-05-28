package app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.Country;
import app.repositories.CountryRepository;

@Service
public class CountryService {

	
	@Autowired
	CountryRepository couRep;
	
	public List<Country> getAll() {
		return couRep.findAll();
	}
	
	public Country getOne(Long id) {
		return couRep.findById(id).orElse(null);
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
