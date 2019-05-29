package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import app.entities.CalendarEvent;

@Repository
public interface CalendarRepository extends JpaRepository<CalendarEvent, Long> {
	
	@Query("SELECT e FROM CalendarEvent e WHERE MONTH(e.dateEvent)=?1 AND YEAR(e.dateEvent)=?2")
	List<CalendarEvent> findEventsInMonth(Integer month, Integer year);
	
	@Query("SELECT e FROM CalendarEvent e WHERE DAY(e.dateEvent)=?1 AND MONTH(e.dateEvent)=?2 AND YEAR(e.dateEvent)=?3")
	List<CalendarEvent> findEventsInDay(Integer day, Integer month, Integer year);
	
	
}