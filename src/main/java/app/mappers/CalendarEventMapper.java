package app.mappers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.dto.CalendarEventDto;
import app.entities.CalendarEvent;

@Component
public class CalendarEventMapper implements Mapper<CalendarEvent, CalendarEventDto>{
	
	@Autowired
	StudyYearMapper studyYearMapper;

	public CalendarEventDto toDTO(CalendarEvent calendarEvent) {
		
		if(calendarEvent == null ) {
			return null;
		}
		
		CalendarEventDto retVal = new CalendarEventDto();
			retVal.setId(calendarEvent.getId());
			retVal.setDateEvent(calendarEvent.getDateEvent());
			retVal.setHeader(calendarEvent.getHeader());
			retVal.setType(calendarEvent.getType());
			retVal.setInfo(calendarEvent.getInfo());
			retVal.setStudyYearDto(studyYearMapper.toDTO(calendarEvent.getStudyYear()));
			return retVal;

	}
	
	public CalendarEvent toEntity(CalendarEventDto calendarEventDto) {
		if(calendarEventDto == null) {
			return null;
		}
		
		CalendarEvent calendarEvent = new CalendarEvent();
		
		calendarEvent.setId(calendarEventDto.getId());
		calendarEvent.setHeader(calendarEventDto.getHeader());
		calendarEvent.setDateEvent(calendarEventDto.getDateEvent());
		calendarEvent.setInfo(calendarEventDto.getInfo());
		calendarEvent.setType(calendarEventDto.getType());
		calendarEvent.setStudyYear(studyYearMapper.toEntity(calendarEventDto.getStudyYearDto()));
		
		return calendarEvent;
	}
	
	public List<CalendarEventDto> toDTO(List<CalendarEvent> calendarEvent){
		
		if(calendarEvent == null) {
			return null;
		}
		
		List<CalendarEventDto > retVal = new ArrayList<CalendarEventDto >();
		for (CalendarEvent calendarEvents: calendarEvent) {
			retVal.add(toDTO(calendarEvents));
		}
		return retVal;
	}


	@Override
	public Collection<CalendarEvent> toEntity(Collection<CalendarEventDto> calendarEventDto) {
		if(calendarEventDto == null) {
			return null;
		}
		
		Collection<CalendarEvent> calendarEvent = new ArrayList<CalendarEvent>(calendarEventDto.size());
		for(CalendarEventDto cDto: calendarEventDto) {
			calendarEvent.add(toEntity(cDto));
		}
		
		return calendarEvent;
	}
		


	
}
