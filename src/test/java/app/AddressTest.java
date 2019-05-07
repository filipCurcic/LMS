package app;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import app.entities.Address;
import app.entities.City;
import app.entities.Country;
import app.repositories.AddressRepository;
import app.repositories.CityRepository;
import app.repositories.CountryRepository;
import app.services.AddressService;
import app.services.CityService;
import app.services.CountryService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
@AutoConfigureMockMvc
public class AddressTest {

	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	AddressService addressService;
	
	@Autowired
	AddressRepository addressRepository;

	@Autowired
	CityService cityService;
	
	@Autowired
	CityRepository cityRepository;
	
	@Autowired
	CountryService countryService;
	
	@Autowired
	CountryRepository countryRepository;
	
	@Before
	public void setupAddress() {
		countryService.addCountry(new Country(1l, "Serbia"));
		countryService.addCountry(new Country(2l, "USA"));
		countryService.addCountry(new Country(3l, "France"));
		countryService.addCountry(new Country(4l, "Italy"));
		countryService.addCountry(new Country(5l, "Spain"));
		cityRepository.save(new City(1l, "Novi Sad", countryService.getOne(1l).get()));
		cityRepository.save(new City(2l, "New York", countryService.getOne(2l).get()));
		cityRepository.save(new City(3l, "Paris", countryService.getOne(3l).get()));
		cityRepository.save(new City(4l, "Milan", countryService.getOne(4l).get()));
		cityRepository.save(new City(5l, "Madrid", countryService.getOne(5l).get()));
		addressRepository.save(new Address(1l, "Bulevar Oslobodjenja", "22a", cityService.getOne(1l).get()));
		addressRepository.save(new Address(2l, "5th Ave", "2584", cityService.getOne(2l).get()));
		addressRepository.save(new Address(3l, "The Oldie", "1564", cityService.getOne(3l).get()));
		addressRepository.save(new Address(4l, "Corso Venezia", "168", cityService.getOne(4l).get()));
		addressRepository.save(new Address(5l, " Calle Fuencarral", "111", cityService.getOne(5l).get()));
	}

}
