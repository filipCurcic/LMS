package app.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import app.dto.CountryDto;
import app.dto.TitleTypeDto;
import app.entities.Country;
import app.entities.Title;
import app.entities.TitleType;

@Component
public class TitleTypeMapper implements Mapper<TitleType, TitleTypeDto> {
	
	public TitleTypeDto toDTO(TitleType titleType) {
		TitleTypeDto retVal = new TitleTypeDto();
			retVal.setId(titleType.getId());
			retVal.setName(titleType.getName());
			retVal.setVersion(titleType.getVersion());
			retVal.setTitle(new ArrayList<>());
			for (Title title: titleType.getTitle()) {
				retVal.getTitle().add("/title/"+title.getId());
			}
			return retVal;

	}
	
	public TitleType toEntity(TitleTypeDto titleTypeDto) {
		return null;		
	}
	
	public List<TitleTypeDto> toDTO(List<TitleType> titleType){
		List<TitleTypeDto > retVal = new ArrayList<TitleTypeDto >();
		for (TitleType titles: titleType) {
			retVal.add(toDTO(titles));
		}
		return retVal;
	}

	public List<TitleType> toEntity(List<TitleTypeDto > titleTypeDto){
		return null;
	}

}
