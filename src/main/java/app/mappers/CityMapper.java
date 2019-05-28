package app.mappers;

import java.util.ArrayList;
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
		CityDto retVal = new CityDto();
			retVal.setId(city.getId());
			retVal.setName(city.getName());
			retVal.setVersion(city.getVersion());
		//	city.getCountry().getName();
			retVal.setCountryDto(new CountryDto());
			retVal.setCountryDto(countryMapper.toDTO(city.getCountry()));
			retVal.setAddress(new ArrayList<>());
			for (Address address: city.getAddress()) {
				retVal.getAddress().add("/address/"+address.getId());
			}
			return retVal;

	}
	
	public City toEntity(CityDto cityDto) {
		return null;		
	}
	
	public List<CityDto> toDTO(List<City> city){
		List<CityDto> retVal = new ArrayList<CityDto >();
		for (City cities: city) {
			retVal.add(toDTO(cities));
		}
		return retVal;
	}

	public List<City> toEntity(List<CityDto> cityDto){
		return null;
	}

	

}
