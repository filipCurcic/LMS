package app.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.dto.ScientificFieldDto;
import app.dto.TeacherDto;
import app.dto.TitleDto;
import app.dto.TitleTypeDto;
import app.entities.Title;

@Component
public class TitleMapper implements Mapper<Title, TitleDto> {

	@Autowired
	TeacherMapper teacherMapper;
	
	@Autowired
	ScientificFieldMapper scientificFieldMapper;
	
	@Autowired
	TitleTypeMapper titleTipyMapper;
	

	public TitleDto toDTO(Title title) {
		System.out.println("sssss");
		TitleDto retVal = new TitleDto();
			retVal.setId(title.getId());
			retVal.setName(title.getName());
			retVal.setDateOfCessation(title.getDateOfCessation());
			retVal.setDateOfSelection(title.getDateOfSelection());
			retVal.setVersion(title.getVersion());
			retVal.setScientificFieldDto(scientificFieldMapper.toDTO(title.getScientificField()));
			retVal.setTeacherDto(new TeacherDto());
			retVal.setTeacherDto(teacherMapper.toDTO(title.getTeacher()));
			retVal.setTitleTypeDto(new TitleTypeDto());
			retVal.setTitleTypeDto(titleTipyMapper.toDTO(title.getTitleType()));
			return retVal;

	}
	
	public Title toEntity(TitleDto titleDto) {
		return null;		
	}
	
	public List<TitleDto> toDTO(List<Title> title){
		List<TitleDto > retVal = new ArrayList<TitleDto >();
		for (Title titles: title) {
			System.out.println("------");
			retVal.add(toDTO(titles));
		}
		return retVal;
	}

	public List<Title> toEntity(List<TitleDto > titleDto){
		return null;
	}

}
