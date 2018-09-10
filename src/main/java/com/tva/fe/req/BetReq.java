package com.tva.fe.req;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BetReq {
	// region -- Fields --

	@JsonProperty(value = "id")
	private Integer id;

	@JsonProperty(value = "calendarId")
	private Integer calendarId;

	@JsonProperty(value = "code")
	private String code;

	@JsonProperty(value = "g11")
	private Integer g11;

	@JsonProperty(value = "g21")
	private Integer g21;

	@JsonProperty(value = "g22")
	private Integer g22;

	@JsonProperty(value = "g31")
	private Integer g31;

	@JsonProperty(value = "g41")
	private Integer g41;

	@JsonProperty(value = "amount")
	private Float amount;

	@JsonProperty(value = "subQuestion")
	private Integer subQuestion;

	@JsonProperty(value = "status")
	private String status;

	// end

	// region -- Get set --

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCalendarId() {
		return calendarId;
	}

	public void setCalendarId(Integer calendarId) {
		this.calendarId = calendarId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getG11() {
		return g11;
	}

	public void setG11(Integer g11) {
		this.g11 = g11;
	}

	public Integer getG21() {
		return g21;
	}

	public void setG21(Integer g21) {
		this.g21 = g21;
	}

	public Integer getG22() {
		return g22;
	}

	public void setG22(Integer g22) {
		this.g22 = g22;
	}

	public Integer getG31() {
		return g31;
	}

	public void setG31(Integer g31) {
		this.g31 = g31;
	}

	public Integer getG41() {
		return g41;
	}

	public void setG41(Integer g41) {
		this.g41 = g41;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public Integer getSubQuestion() {
		return subQuestion;
	}

	public void setSubQuestion(Integer subQuestion) {
		this.subQuestion = subQuestion;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	// end

	// region -- Methods --

	public BetReq() {
	}

	// end
}