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
@Table(name = "calendar", schema = "public")
public class Calendar {
	// region -- Fields --

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "calendar_id_seq_generator")
	@SequenceGenerator(name = "calendar_id_seq_generator", sequenceName = "public.calendar_id_seq", allocationSize = 1)
	@Column(columnDefinition = "SERIAL")
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
	private Date competitionDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
	private Date startGuess;

	@Column(columnDefinition = "integer",name="team1_id")
	private Integer team1Id;

	@Column(columnDefinition = "integer",name="team2_id")
	private Integer team2Id;

	@Column(columnDefinition = "varchar(64)")
	private String stadium;

	@Column(columnDefinition = "varchar(64)")
	private Integer referee;

	@Column(columnDefinition = "text")
	private Integer squad1;

	@Column(columnDefinition = "text")
	private Integer squad2;

	@Column(columnDefinition = "bool")
	private boolean isGroupMatch;

	@Column(columnDefinition = "integer")
	private Integer r1;

	@Column(columnDefinition = "integer")
	private Integer r2;

	@Column(columnDefinition = "integer")
	private Integer r11;

	@Column(columnDefinition = "integer")
	private Integer r21;

	@Column(columnDefinition = "integer")
	private Integer r12;

	@Column(columnDefinition = "integer")
	private Integer r22;

	@Column(columnDefinition = "integer")
	private Integer winTeam;

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

	public Date getCompetitionDate() {
		return competitionDate;
	}

	public void setCompetitionDate(Date competitionDate) {
		this.competitionDate = competitionDate;
	}

	public Date getStartGuess() {
		return startGuess;
	}

	public void setStartGuess(Date startGuess) {
		this.startGuess = startGuess;
	}

	public Integer getTeam1Id() {
		return team1Id;
	}

	public void setTeam1Id(Integer team1Id) {
		this.team1Id = team1Id;
	}

	public Integer getTeam2Id() {
		return team2Id;
	}

	public void setTeam2Id(Integer team2Id) {
		this.team2Id = team2Id;
	}

	public String getStadium() {
		return stadium;
	}

	public void setStadium(String stadium) {
		this.stadium = stadium;
	}

	public Integer getReferee() {
		return referee;
	}

	public void setReferee(Integer referee) {
		this.referee = referee;
	}

	public Integer getSquad1() {
		return squad1;
	}

	public void setSquad1(Integer squad1) {
		this.squad1 = squad1;
	}

	public Integer getSquad2() {
		return squad2;
	}

	public void setSquad2(Integer squad2) {
		this.squad2 = squad2;
	}

	public boolean isIsGroupMatch() {
		return isGroupMatch;
	}

	public void setIsGroupMatch(boolean is_group_match) {
		this.isGroupMatch = is_group_match;
	}

	public Integer getR1() {
		return r1;
	}

	public void setR1(Integer r1) {
		this.r1 = r1;
	}

	public Integer getR2() {
		return r2;
	}

	public void setR2(Integer r2) {
		this.r2 = r2;
	}

	public Integer getR11() {
		return r11;
	}

	public void setR11(Integer r11) {
		this.r11 = r11;
	}

	public Integer getR21() {
		return r21;
	}

	public void setR21(Integer r21) {
		this.r21 = r21;
	}

	public Integer getR12() {
		return r12;
	}

	public void setR12(Integer r12) {
		this.r12 = r12;
	}

	public Integer getR22() {
		return r22;
	}

	public void setR22(Integer r22) {
		this.r22 = r22;
	}

	public Integer getWinTeam() {
		return winTeam;
	}

	public void setWinTeam(Integer winTeam) {
		this.winTeam = winTeam;
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

	public Calendar() {
		this.isDeleted = false;
		this.isGroupMatch = false;
	}

	// end
}