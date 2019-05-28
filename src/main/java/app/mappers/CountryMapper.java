package app.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.dto.CountryDto;
import app.entities.City;
import app.entities.Country;

@Component
public class CountryMapper implements Mapper<Country, CountryDto> {
	
	@Autowired
	CityMapper cityMapper;
	

	public CountryDto toDTO(Country country) {
		CountryDto retVal = new CountryDto();
			retVal.setId(country.getId());
			retVal.setName(country.getName());
			retVal.setVersion(country.getVersion());
			retVal.setCity(new ArrayList<>());
			for (City city: country.getCity()) {
				retVal.getCity().add("/city/"+city.getId());
			}
			return retVal;

	}
	
	public Country toEntity(CountryDto countryDto) {
		return null;		
	}
	
	public List<CountryDto> toDTO(List<Country> country){
		List<CountryDto > retVal = new ArrayList<CountryDto >();
		for (Country countries: country) {
			retVal.add(toDTO(countries));
		}
		return retVal;
	}

	public List<Country> toEntity(List<CountryDto > countryDto){
		return null;
	}

}