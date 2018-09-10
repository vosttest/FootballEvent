package com.tva.fe.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.tva.fe.common.Const;

@Entity
@Table(name = "bet", schema = "public")
public class Bet {
	// region -- Fields --

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bet_id_seq_generator")
	@SequenceGenerator(name = "bet_id_seq_generator", sequenceName = "public.bet_id_seq", allocationSize = 1)
	@Column(columnDefinition = "SERIAL")
	private Integer id;

	@Column(columnDefinition = "integer")
	private Integer calendarId;

	@Column(columnDefinition = "varchar(64)")
	private String code;

	@Column(columnDefinition = "integer")
	private Integer g11;

	@Column(columnDefinition = "integer")
	private Integer g21;

	@Column(columnDefinition = "integer")
	private Integer g22;

	@Column(columnDefinition = "integer")
	private Integer g31;

	@Column(columnDefinition = "integer")
	private Integer g41;
	
	@Column(columnDefinition = "float")
	private Float amount;

	@Column(columnDefinition = "integer")
	private Integer subQuestion;

	@Column(columnDefinition = "varchar(32)")
	private String status;

	@Column(columnDefinition = "integer")
	private Integer userId;

	@Column(columnDefinition = "bool")
	private boolean isDeleted;

	@Column(columnDefinition = "integer")
	private Integer createBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
	private Date createOn;

	@Column(columnDefinition = "integer")
	private Integer modifyBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
	private Date modifyOn;

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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Integer getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}

	public Date getCreateOn() {
		return createOn;
	}

	public void setCreateOn(Date createOn) {
		this.createOn = createOn;
	}

	public Integer getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
	}

	public Date getModifyOn() {
		return modifyOn;
	}

	public void setModifyOn(Date modifyOn) {
		this.modifyOn = modifyOn;
	}

	// end

	// region -- Methods --

	public Bet() {
		this.isDeleted = false;
		this.status = Const.STATUS_INACTIVE;
	}

	// end
}