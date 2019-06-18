package app.mappers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.dto.CityDto;
import app.dto.CountryDto;
import app.entities.City;
import app.entities.Country;

@Component
public class CountryMapper implements Mapper<Country, CountryDto> {
	
	@Autowired
	CityMapper cityMapper;
	

	public CountryDto toDTO(Country country) {
		
		if(country == null) {
			return null;
		}
		
		CountryDto retVal = new CountryDto();
			retVal.setId(country.getId());
			retVal.setName(country.getName());
			return retVal;

	}
	
	public Collection<Country> toEntity(Collection<CountryDto> countryDto) {
		if ( countryDto == null ) {
            return null;
        }

        Collection<Country> country = new ArrayList<Country>( countryDto.size() );
        for ( CountryDto cDto: countryDto) {
            country.add( toEntity( cDto ) );
        }

        return country;
		
	}
	
	public List<CountryDto> toDTO(List<Country> country){
		
		if(country == null) {
			return null;
		}
		
		List<CountryDto > retVal = new ArrayList<CountryDto >();
		for (Country countries: country) {
			retVal.add(toDTO(countries));
		}
		return retVal;
	}

	public Country toEntity(CountryDto countryDto){
		if ( countryDto == null ) {
            return null;
        }

        Country country = new Country();

        country.setId( countryDto.getId());
        country.setName( countryDto.getName());
        
		return country;
	}

}