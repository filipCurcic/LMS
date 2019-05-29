package app.mappers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import app.dto.TitleTypeDto;
import app.entities.Title;
import app.entities.TitleType;

@Component
public class TitleTypeMapper implements Mapper<TitleType, TitleTypeDto> {
	
	public TitleTypeDto toDTO(TitleType titleType) {
		
		if(titleType == null) {
			return null;
		}
		
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
		if(titleTypeDto == null) {
			return null;		
		}
		
		TitleType titleType = new TitleType();
		
		titleType.setId(titleTypeDto.getId());
		titleType.setName(titleTypeDto.getName());
		titleType.setVersion(titleTypeDto.getVersion());
		
		return titleType;
	}
	
	public List<TitleTypeDto> toDTO(List<TitleType> titleType){
		
		if(titleType == null) {
			return null;
		}
		
		List<TitleTypeDto > retVal = new ArrayList<TitleTypeDto >();
		for (TitleType titles: titleType) {
			retVal.add(toDTO(titles));
		}
		return retVal;
	}

	public Collection<TitleType> toEntity(Collection<TitleTypeDto > titleTypeDto){
		if(titleTypeDto == null) {
			return null;
		}
		
		Collection<TitleType> titleType = new ArrayList<TitleType>(titleTypeDto.size());
		for(TitleTypeDto tDto: titleTypeDto) {
			titleType.add(toEntity(tDto));
		}
		
		return titleType;
	}

}
