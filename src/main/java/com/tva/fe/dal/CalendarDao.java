package com.tva.fe.dal;

import org.springframework.data.repository.CrudRepository;

import com.tva.fe.model.Calendar;

public interface CalendarDao extends CrudRepository<Calendar, Integer> {

}