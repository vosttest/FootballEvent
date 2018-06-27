package com.tva.fe.dal;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tva.fe.model.Calendar;

public interface CalendarDao extends CrudRepository<Calendar, Integer> {
	@Query("FROM Calendar WHERE competition_date BETWEEN :fromDate AND :toDate")
	public List<Calendar> getBy(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate);

}