package com.tva.fe.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TeamDto {
	// region -- Fields --

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

	// end

	// region -- Get set --

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

	// end

	// region -- Methods --

	public TeamDto() {

	}
	// end
}