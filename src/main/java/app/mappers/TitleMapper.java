package app.mappers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
		
		if(title == null) {
			return null;
		}
		
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
		if(titleDto == null) {
			return null;	
		}
		
		Title title = new Title();
		
		title.setId(titleDto.getId());
		title.setDateOfCessation(titleDto.getDateOfCessation());
		title.setDateOfSelection(titleDto.getDateOfSelection());
		title.setName(titleDto.getName());
		title.setScientificField(scientificFieldMapper.toEntity(titleDto.getScientificFieldDto()));
		title.setVersion(titleDto.getVersion());
		title.setTitleType(titleTipyMapper.toEntity(titleDto.getTitleTypeDto()));
		title.setTeacher(teacherMapper.toEntity(titleDto.getTeacherDto()));
		
		return title;
	}
	
	public List<TitleDto> toDTO(List<Title> title){
		
		if(title == null) {
			return null;
		}
		
		List<TitleDto > retVal = new ArrayList<TitleDto >();
		for (Title titles: title) {
			retVal.add(toDTO(titles));
		}
		return retVal;
	}

	public Collection<Title> toEntity(Collection<TitleDto > titleDto){
		if(titleDto == null) {
			return null;
		}
		
		Collection<Title> title = new ArrayList<Title>(titleDto.size());
		for(TitleDto tDto: titleDto) {
			title.add(toEntity(tDto));
		}
		
		return title;
	}

}
