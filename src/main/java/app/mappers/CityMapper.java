package app.mappers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.dto.CityDto;
import app.dto.CountryDto;
import app.entities.Address;
import app.entities.City;

@Component
public class CityMapper implements Mapper<City, CityDto> {
	
	@Autowired
	AddressMapper addressMapper;
	
	@Autowired
	CountryMapper countryMapper;
	

	public CityDto toDTO(City city) {
		
		if(city == null) {
			return null;
		}
		
		CityDto retVal = new CityDto();
			retVal.setId(city.getId());
			retVal.setName(city.getName());
			retVal.setVersion(city.getVersion());
			retVal.setCountryDto(new CountryDto());
			retVal.setCountryDto(countryMapper.toDTO(city.getCountry()));
			retVal.setAddress(new ArrayList<>());
			for (Address address: city.getAddress()) {
				retVal.getAddress().add("/address/"+address.getId());
			}
			return retVal;

	}
	
	public Collection<City> toEntity(Collection<CityDto> cityDto) {
		if(cityDto == null) {
			return null;
		}
		
		Collection<City> city = new ArrayList<City>(cityDto.size());
		for(CityDto cDto: cityDto) {
			city.add(toEntity(cDto));
		}
		
		return city;
	}
	
	public List<CityDto> toDTO(List<City> city){
		
		if(city == null) {
			return null;
		}
		
		List<CityDto> retVal = new ArrayList<CityDto >();
		for (City cities: city) {
			retVal.add(toDTO(cities));
		}
		return retVal;
	}

	public City toEntity(CityDto cityDto){
		if( cityDto == null) { 
			return null;
		}
		
		City city = new City();
		
		city.setId(cityDto.getId());
		city.setName(cityDto.getName());
		city.setVersion(cityDto.getVersion());
		city.setCountry(countryMapper.toEntity(cityDto.getCountryDto()));
		return city;
	}
	

}
