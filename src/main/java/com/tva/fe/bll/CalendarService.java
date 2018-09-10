package com.tva.fe.bll;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tva.fe.dal.CalendarDao;
import com.tva.fe.dto.CalendarDetail;
import com.tva.fe.dto.CalendarDto;

@Service(value = "calendarService")
@Transactional
public class CalendarService {
	// region -- Fields --

	@Autowired
	private CalendarDao calendarDao;

	// end

	// region -- Methods --

	public List<CalendarDto> getCalendar(Date fromDate, Date toDate) {
		List<Object[]> t = calendarDao.getBy(fromDate, toDate);
		List<CalendarDto> res = new ArrayList<>();
		CalendarDto t1 = new CalendarDto();
		List<CalendarDetail> lstCalendar = new ArrayList<>();
		int count = 0;
		for (Object[] item : t) {
			SimpleDateFormat fo = new SimpleDateFormat("yyyy-MM-dd");
			Date t3 = new Date();
			try {
				t3 = fo.parse(item[0].toString());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int a = fromDate.compareTo(t3);
			if (a > 0) {
				fromDate = (Date) item[0];
				if (t1.getCompetitionDate() == null) {
					t1.setCompetitionDate((Date) item[0]);
					res.add(t1);
				}
				count++;
			} else {
				t1 = new CalendarDto();
				lstCalendar = new ArrayList<>();
				t1.setCompetitionDate((Date) item[0]);
				fromDate = (Date) item[0];
				count = 0;
			}

			CalendarDetail t2 = new CalendarDetail();
			t2.setCompetitionDate1((Date) item[0]);
			t2.setTeam1Id(Integer.parseInt(item[2].toString()));
			t2.setName1(item[3].toString());
			t2.setLogo1(item[4].toString());
			t2.setTeam2Id(Integer.parseInt(item[5].toString()));
			t2.setName2(item[6].toString());
			t2.setLogo2(item[7].toString());
			t2.setCalendarId((Integer) item[8]);

			lstCalendar.add(t2);
			t1.setCalendarDetail(lstCalendar);
			if (count == 0) {
				res.add(t1);
			}
		}

		return res;
	}

	// end
}