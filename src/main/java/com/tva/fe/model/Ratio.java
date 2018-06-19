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

@Entity
@Table(name = "ratio", schema = "public")
public class Ratio {
	// region -- Fields --

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ratio_id_seq_generator")
	@SequenceGenerator(name = "ratio_id_seq_generator", sequenceName = "public.ratio_id_seq", allocationSize = 1)
	@Column(columnDefinition = "SERIAL")
	private Integer id;

	@Column(columnDefinition = "integer")
	private Integer calendarId;

	@Column(columnDefinition = "varchar(64)")
	private String code;

	@Column(columnDefinition = "float")
	private Float r11;

	@Column(columnDefinition = "float")
	private Float r12;

	@Column(columnDefinition = "float")
	private Float r13;

	@Column(columnDefinition = "float")
	private Float r21;

	@Column(columnDefinition = "float")
	private Float r22;

	@Column(columnDefinition = "float")
	private Float r3;

	@Column(columnDefinition = "float")
	private Float r4;

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

	public Float getR11() {
		return r11;
	}

	/**
	 * Bet team 1 win
	 */
	public void setR11(Float r11) {
		this.r11 = r11;
	}

	public Float getR12() {
		return r12;
	}

	/**
	 * Bet 2 teams draw
	 */
	public void setR12(Float r12) {
		this.r12 = r12;
	}

	public Float getR13() {
		return r13;
	}

	/**
	 * Bet team 2 win
	 */
	public void setR13(Float r13) {
		this.r13 = r13;
	}

	public Float getR21() {
		return r21;
	}

	/**
	 * Bet final result of team 1 (final result of team 2 is required)
	 */
	public void setR21(Float r21) {
		this.r21 = r21;
	}

	public Float getR22() {
		return r22;
	}

	/**
	 * Bet final result of team 2 (final result of team 1 is required)
	 */
	public void setR22(Float r22) {
		this.r22 = r22;
	}

	public Float getR3() {
		return r3;
	}

	/**
	 * Bet tài xỉu
	 */
	public void setR3(Float r3) {
		this.r3 = r3;
	}

	public Float getR4() {
		return r4;
	}

	/**
	 * Bet champion of tournament
	 */
	public void setR4(Float r4) {
		this.r4 = r4;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
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

	public Ratio() {
		this.isDeleted = false;
	}

	// end
}