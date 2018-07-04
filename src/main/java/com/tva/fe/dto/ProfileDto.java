package com.tva.fe.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProfileDto {
	// region -- Fields --

	@JsonProperty(value = "userName")
	private String userName;

	@JsonProperty(value = "amount")
	private double amount;

	// end

	// region -- Get set --

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	// end

	// region -- Methods --

	public ProfileDto() {
	}

	// end
}