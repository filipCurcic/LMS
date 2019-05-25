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
import app.entities.Country;

@Component
public class CityMapper implements Mapper<City, CityDto> {
	
	@Autowired
	AddressMapper addressMapper;
	

	public CityDto toDTO(City city) {
		CityDto retVal = new CityDto();
			retVal.setId(city.getId());
			retVal.setName(city.getName());
			retVal.setVersion(city.getVersion());
			retVal.setAddress(new ArrayList<>());
			for (Address address: city.getAddress()) {
				retVal.getAddress().add("/address/"+address.getId());
			}
			//retVal.setCity(CityMapper.toDTO(country.g));
			return retVal;

	}
	
	public Country toEntity(CountryDto countryDto) {
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
		// TODO implementirati logiku konverzije
		return null;
	}

	@Override
	public City toEntity(CityDto edto) {
		// TODO Auto-generated method stub
		return null;
	}

}
