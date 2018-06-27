package com.tva.fe.bll;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tva.fe.dal.CalendarDao;
import com.tva.fe.model.Calendar;

@Service(value = "calendarService")
@Transactional
public class CalendarService {
	// region -- Fields --

	@Autowired
	private CalendarDao calendarDao;

	// end

	// region -- Methods --

	public List<Calendar> getDate(Date fromDate, Date toDate) {
		List<Calendar> res = calendarDao.getBy(fromDate, toDate);
		return res;
	}

	// end
}