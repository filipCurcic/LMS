package app.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class CalendarEvent {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private Date dateEvent;
	@NotNull
	private String header;
	@NotNull
	private String type;
	@NotNull
	private String info;
	@ManyToOne
	private StudyYear studyYear;
	
	public CalendarEvent() {}

	public CalendarEvent(Long id, @NotNull Date dateEvent, @NotNull String header, @NotNull String type,
			@NotNull String info, StudyYear studyYear) {
		super();
		this.id = id;
		this.dateEvent = dateEvent;
		this.header = header;
		this.type = type;
		this.info = info;
		this.studyYear = studyYear;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateEvent() {
		return dateEvent;
	}

	public void setDateEvent(Date dateEvent) {
		this.dateEvent = dateEvent;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public StudyYear getStudyYear() {
		return studyYear;
	}

	public void setStudyYear(StudyYear studyYear) {
		this.studyYear = studyYear;
	}
	
	
	
}
