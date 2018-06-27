package com.tva.fe.req;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CalendarReq {
	// region -- Fields --

	@JsonProperty(value = "fromDate")
	private Date fromDate;

	@JsonProperty(value = "toDate")
	private Date toDate;

	// end

	// region -- Get set --

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

	// end

	// region -- Methods --

	public CalendarReq() {
	}

	// end
}