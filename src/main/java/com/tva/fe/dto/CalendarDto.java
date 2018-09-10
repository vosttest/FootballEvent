package com.tva.fe.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CalendarDto {
	// region -- Fields --

	@JsonProperty(value = "competitionDate")
	private Date competitionDate;

	@JsonProperty(value = "calendarDetail")
	private List<CalendarDetail> calendarDetail;

	// end

	// region -- Get set --

	public Date getCompetitionDate() {
		return competitionDate;
	}

	public void setCompetitionDate(Date competitionDate) {
		this.competitionDate = competitionDate;
	}

	public List<CalendarDetail> getCalendarDetail() {
		return calendarDetail;
	}

	public void setCalendarDetail(List<CalendarDetail> calendarDetail) {
		this.calendarDetail = calendarDetail;
	}

	// end

	// region -- Methods --

	public CalendarDto() {

	}

	// end
}