package com.tva.fe.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CalendarDto {
	// region -- Fields --

	@JsonProperty(value = "id")
	private Integer id;

	// end

	// region -- Get set --

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	// end

	// region -- Methods --

	public CalendarDto() {

	}

	// end
}