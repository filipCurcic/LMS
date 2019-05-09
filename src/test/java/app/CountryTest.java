package app;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;
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

import app.entities.Country;
import app.repositories.CountryRepository;
import app.services.CountryService;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
@AutoConfigureMockMvc
public class CountryTest {
	
	@Autowired
	MockMvc mockMvc;

	@Autowired
	CountryRepository countryRepository;
	
	@Autowired
	CountryService countryService;
	
	@Before
	public void setupCountry() {
		countryService.addCountry(new Country(1l, "Serbia"));
		countryService.addCountry(new Country(2l, "USA"));
		countryService.addCountry(new Country(3l, "Italy"));
		countryService.addCountry(new Country(4l, "France"));
		countryService.addCountry(new Country(5l, "Spain"));
	}
	
	@After
	public void cleanupCountry() {
		countryRepository.deleteAll();
	}
	
	@Test
	public void getCountry() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/country/all").accept(MediaType.APPLICATION_JSON_UTF8))
			.andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(5)));
	}
	
	@Test
	public void getCountryId() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/country/5").accept(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(status().isOk()).andExpect(jsonPath("$", notNullValue()))
		.andExpect(jsonPath("$.name", equalTo("Spain")));
	}
	
	
	@Test
	public void addCountry() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/country/all").accept(MediaType.APPLICATION_JSON_UTF8))
			.andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(5)));
		mockMvc.perform(MockMvcRequestBuilders.post("/country/add").contentType(MediaType.APPLICATION_JSON_UTF8).content(
			"{\"name\": \"England\"}"))
			.andExpect(status().isCreated());
		mockMvc.perform(MockMvcRequestBuilders.get("/country/all").accept(MediaType.APPLICATION_JSON_UTF8))
			.andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(6)));

	}
	
	
	@Test
	public void removeCountry() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/country/all").accept(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(5)));
		mockMvc.perform(MockMvcRequestBuilders.delete("/country/1").accept(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isGone());
		mockMvc.perform(MockMvcRequestBuilders.get("/country/all").accept(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(4)));
	}

}
