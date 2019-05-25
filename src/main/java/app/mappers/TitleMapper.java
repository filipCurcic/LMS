package app.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.dto.TitleDto;
import app.entities.Title;

@Component
public class TitleMapper implements Mapper<Title, TitleDto> {

	@Autowired
	CityMapper cityMapper;
	

	public TitleDto toDTO(Title title) {
		TitleDto retVal = new TitleDto();
			retVal.setId(title.getId());
			retVal.setName(title.getName());
			retVal.setDateOfCessation(title.getDateOfCessation());
			retVal.setDateOfSelection(title.getDateOfSelection());
			retVal.setVersion(title.getVersion());
			return retVal;

	}
	
	public Title toEntity(TitleDto titleDto) {
		return null;		
	}
	
	public List<TitleDto> toDTO(List<Title> title){
		List<TitleDto > retVal = new ArrayList<TitleDto >();
		for (Title titles: title) {
			retVal.add(toDTO(titles));
		}
		return retVal;
	}

	public List<Title> toEntity(List<TitleDto > titleDto){
		return null;
	}

}
