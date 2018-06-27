package com.tva.fe.req;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RatioReq {
	// region -- Fields --

	@JsonProperty(value = "id")
	private int id;

	@JsonProperty(value = "calendarId")
	private int calendarId;

	@JsonProperty(value = "code")
	private String code;

	@JsonProperty(value = "r11")
	private Float r11;

	@JsonProperty(value = "r12")
	private Float r12;

	@JsonProperty(value = "r13")
	private Float r13;

	@JsonProperty(value = "r21")
	private Float r21;

	@JsonProperty(value = "r22")
	private Float r22;

	@JsonProperty(value = "r31")
	private Float r31;

	@JsonProperty(value = "r32")
	private Float r32;

	@JsonProperty(value = "r33")
	private Float r33;

	@JsonProperty(value = "r4")
	private int r4;

	// end

	// region -- Get set --

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCalendarId() {
		return calendarId;
	}

	public void setCalendarId(int calendarId) {
		this.calendarId = calendarId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Float getR11() {
		return r11;
	}

	public void setR11(Float r11) {
		this.r11 = r11;
	}

	public Float getR12() {
		return r12;
	}

	public void setR12(Float r12) {
		this.r12 = r12;
	}

	public Float getR13() {
		return r13;
	}

	public void setR13(Float r13) {
		this.r13 = r13;
	}

	public Float getR21() {
		return r21;
	}

	public void setR21(Float r21) {
		this.r21 = r21;
	}

	public Float getR22() {
		return r22;
	}

	public void setR22(Float r22) {
		this.r22 = r22;
	}

	public Float getR31() {
		return r31;
	}

	public void setR31(Float r31) {
		this.r31 = r31;
	}

	public Float getR32() {
		return r32;
	}

	public void setR32(Float r32) {
		this.r32 = r32;
	}

	public Float getR33() {
		return r33;
	}

	public void setR33(Float r33) {
		this.r33 = r33;
	}

	public int getR4() {
		return r4;
	}

	public void setR4(int r4) {
		this.r4 = r4;
	}

	// end

	// region -- Methods --

	public RatioReq() {
	}

	// end
}