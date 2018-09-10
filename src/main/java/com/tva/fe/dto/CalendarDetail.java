package com.tva.fe.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CalendarDetail {
	// region -- Fields --

	@JsonProperty(value = "competitionDate1")
	private Date competitionDate1;

	@JsonProperty(value = "startGuess")
	private Date startGuess;

	@JsonProperty(value = "team1Id")
	private int team1Id;

	@JsonProperty(value = "name1")
	private String name1;

	@JsonProperty(value = "logo1")
	private String logo1;

	@JsonProperty(value = "team2Id")
	private int team2Id;

	@JsonProperty(value = "name2")
	private String name2;

	@JsonProperty(value = "logo2")
	private String logo2;

	@JsonProperty(value = "calendarId")
	private int calendarId;

	// end

	// region -- Get set --

	public Date getStartGuess() {
		return startGuess;
	}

	public Date getCompetitionDate1() {
		return competitionDate1;
	}

	public void setCompetitionDate1(Date competitionDate1) {
		this.competitionDate1 = competitionDate1;
	}

	public void setStartGuess(Date startGuess) {
		this.startGuess = startGuess;
	}

	public int getTeam1Id() {
		return team1Id;
	}

	public void setTeam1Id(int team1Id) {
		this.team1Id = team1Id;
	}

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public String getLogo1() {
		return logo1;
	}

	public void setLogo1(String logo1) {
		this.logo1 = logo1;
	}

	public int getTeam2Id() {
		return team2Id;
	}

	public void setTeam2Id(int team2Id) {
		this.team2Id = team2Id;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public String getLogo2() {
		return logo2;
	}

	public void setLogo2(String logo2) {
		this.logo2 = logo2;
	}

	public int getCalendarId() {
		return calendarId;
	}

	public void setCalendarId(int calendarId) {
		this.calendarId = calendarId;
	}

	// end

	// region -- Methods --

	public CalendarDetail() {

	}

	// end
}