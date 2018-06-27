package com.tva.fe.req;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatementReq {
	// region -- Fields --

	@JsonProperty(value = "id")
	private int id;

	@JsonProperty(value = "name")
	private String name;

	@JsonProperty(value = "fromDate")
	private Date fromDate;

	@JsonProperty(value = "toDate")
	private Date toDate;

	@JsonProperty(value = "history")
	private String history;

	@JsonProperty(value = "code")
	private String code;

	@JsonProperty(value = "isLegs")
	private Boolean isLegs;

	@JsonProperty(value = "number")
	private int number;

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

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Boolean getIsLegs() {
		return isLegs;
	}

	public void setIsLegs(Boolean isLegs) {
		this.isLegs = isLegs;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	// end

	// region -- Methods --

	public StatementReq() {
	}

	// end
}