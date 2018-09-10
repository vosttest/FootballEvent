package com.tva.fe.req;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TeamReq {
	// region -- Fields --

	@JsonProperty(value = "id")
	private int id;

	@JsonProperty(value = "name")
	private String name;

	@JsonProperty(value = "country")
	private String country;

	@JsonProperty(value = "continent")
	private String continent;

	@JsonProperty(value = "coach")
	private String coach;

	@JsonProperty(value = "logo")
	private String logo;

	@JsonProperty(value = "history")
	private String history;

	@JsonProperty(value = "condition")
	private String[] condition;

	// end

	// region -- Get set --

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getCoach() {
		return coach;
	}

	public void setCoach(String coach) {
		this.coach = coach;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String[] getCondition() {
		return condition;
	}

	public void setCondition(String[] condition) {
		this.condition = condition;
	}

	// end

	// region -- Methods --

	public TeamReq() {
	}

	// end
}