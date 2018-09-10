package com.tva.fe.req;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GuessReq {
	// region -- Fields --

	@JsonProperty(value = "championId")
	private Integer championId;

	@JsonProperty(value = "top4Id")
	private String top4Id;

	@JsonProperty(value = "phoneNo")
	private String phoneNo;

	@JsonProperty(value = "subQuestion")
	private Integer subQuestion;

	// end

	// region -- Get set --

	public Integer getChampionId() {
		return championId;
	}

	public void setChampionId(Integer championId) {
		this.championId = championId;
	}

	public String getTop4Id() {
		return top4Id;
	}

	public void setTop4Id(String top4Id) {
		this.top4Id = top4Id;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Integer getSubQuestion() {
		return subQuestion;
	}

	public void setSubQuestion(Integer subQuestion) {
		this.subQuestion = subQuestion;
	}

	// end

	// region -- Methods --

	public GuessReq() {
	}

	// end
}