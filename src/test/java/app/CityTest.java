package app;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import app.entities.City;
import app.entities.Country;
import app.repositories.CityRepository;
import app.repositories.CountryRepository;
import app.services.CityService;
import app.services.CountryService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
@AutoConfigureMockMvc
public class CityTest {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	CityService cityService;
	
	@Autowired
	CityRepository cityRepository;
	
	@Autowired
	CountryService countryService;
	
	@Autowired
	CountryRepository countryRepository;
	
	@Before
/*	public void setupCity() {
		countryService.addCountry(new Country(1l, "Serbia"));
		countryService.addCountry(new Country(2l, "USA"));
		countryService.addCountry(new Country(3l, "France"));
		countryService.addCountry(new Country(4l, "Italy"));
		countryService.addCountry(new Country(5l, "Spain"));
		cityRepository.save(new City(1l, "Novi Sad", countryService.getOne(1l).get()));
		cityRepository.save(new City(2l, "New York", countryService.getOne(2l).get()));
		cityRepository.save(new City(3l, "Paris", countryService.getOne(3l).get()));
		cityRepository.save(new City(4l, "Milano", countryService.getOne(4l).get()));
		cityRepository.save(new City(5l, "Madrid", countryService.getOne(5l).get()));
		
	}*/
	
	@After
	public void cleanupCity() {
		cityRepository.deleteAll();
		countryRepository.deleteAll();
	}
	
	@Test
	public void getCity() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/city/all").accept(MediaType.APPLICATION_JSON_UTF8))
			.andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(5)));
}
}
