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
	private Float r31;

	@Column(columnDefinition = "float")
	private Float r32;

	@Column(columnDefinition = "float")
	private Float r33;

	@Column(columnDefinition = "integer")
	private Integer r4;

	@Column(columnDefinition = "varchar(32)")
	private String status;

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

	public Integer getR4() {
		return r4;
	}

	public void setR4(Integer r4) {
		this.r4 = r4;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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