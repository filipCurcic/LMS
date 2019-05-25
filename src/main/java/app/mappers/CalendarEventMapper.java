package app.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import app.dto.CalendarEventDto;
import app.entities.CalendarEvent;

@Component
public class CalendarEventMapper implements Mapper<CalendarEvent, CalendarEventDto>{
	

	public CalendarEventDto toDTO(CalendarEvent calendarEvent) {
		CalendarEventDto retVal = new CalendarEventDto();
			retVal.setId(calendarEvent.getId());
			retVal.setDateEvent(calendarEvent.getDateEvent());
			retVal.setHeader(calendarEvent.getHeader());
			retVal.setType(calendarEvent.getType());
			retVal.setInfo(calendarEvent.getInfo());
			return retVal;

	}
	
	public CalendarEvent toEntity(CalendarEventDto calendarEventDto) {
		return null;		
	}
	
	public List<CalendarEventDto> toDTO(List<CalendarEvent> calendarEvent){
		List<CalendarEventDto > retVal = new ArrayList<CalendarEventDto >();
		for (CalendarEvent calendarEvents: calendarEvent) {
			retVal.add(toDTO(calendarEvents));
		}
		return retVal;
	}

	public List<CalendarEvent> toEntity(List<CalendarEventDto > calendarEventDto){
		return null;
	}


	
}
